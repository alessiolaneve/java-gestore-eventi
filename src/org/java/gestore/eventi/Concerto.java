package org.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* Creare una classe Concerto che estende Evento, che ha anche gli attributi :
ora (LocalTime)
prezzo
 */

public class Concerto extends Evento {

	private LocalTime ora;
	private double prezzo;
	
	public Concerto(String titolo, LocalDate data, int numPostiTot) {
		super(titolo, data, numPostiTot);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	/* Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##€)  */
	public String formattedDate(LocalDate data) {
		DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedD = data.format(formatterD);
		
		DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
		String formattedH = ora.format(formatterH);
		
		return formattedD + " " + formattedH;
	}
	
	public String formattedPrice(double prezzo) {
		return String.format("%.2f €", prezzo);
	}
	
	/* Fare l’ override del metodo toString() in modo che venga restituita una stringa del tipo: 
	   data e ora formattata - titolo - prezzo formattato */
	@Override
	public String toString() {
		return formattedDate(getData()) + " " + getTitolo() + " " + formattedPrice(prezzo);
	}
	
	/* Aggiungere questi attributi nel costruttore e implementarne getter e setter. */
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

}
