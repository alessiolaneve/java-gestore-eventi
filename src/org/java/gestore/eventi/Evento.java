package org.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Creare una classe Evento che abbia le seguenti proprietà:
	-titolo
	-data
	-numero di posti in totale
	-numero di posti prenotati
 */

public class Evento{
	
	private String titolo;
	private LocalDate data;
	private int numPostiTot;
	private int numPostiPren;
	
	
/*  Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel costruttore,
	tranne posti prenotati che va inizializzato a 0.
 */	
	public Evento(String titolo, LocalDate data, int numPostiTot) {
		
		/* Inserire il controllo che la data non sia già passata e che il numero di posti totali sia positivo. 
   In caso contrario mostrare i dovuti avvisi all’utente
		 */	
		if (LocalDate.now().isAfter(data) || numPostiTot <= 0 ) {
			System.out.println("La data o il numero di posti totali inseriti non sono corretti.");
		} 
		else {
		this.titolo = titolo;
		this.data = data;
		this.numPostiTot = numPostiTot;
		this.numPostiPren = 0;
		}
	}

/* Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
   -prenota: aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti disponibili deve restituire 
    un messaggio di avviso.
   -disdici: riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono prenotazioni restituisce un 
    messaggio di avviso.
	l’override del metodo toString() in modo che venga restituita una stringa contenente: data formattata - titolo
	Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
 */
	public void prenota() {
		if (LocalDate.now().isAfter(data) || numPostiPren >= numPostiTot) {
			System.out.println("Non ci sono posti disponibili o l'evento è già passato.");
		} else {
			numPostiPren++;
		}
	}
	
	public void disdici() {
		if (LocalDate.now().isAfter(data) || numPostiPren <= 0) {
			System.out.println("Non è stato ancora prenotato alcun posto o l'evento è già passato.");
		} else {
			numPostiPren--;
		}
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter) + " - " + titolo;
	}
/* Aggiungere metodi getter e setter in modo che:

	-titolo sia in lettura e in scrittura
	-data sia in lettura e scrittura
	-numero di posti totale sia solo in lettura
	-numero di posti prenotati sia solo in lettura
 */
	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public int getNumPostiTot() {
		return numPostiTot;
	}


	public int getNumPostiPren() {
		return numPostiPren;
	}
	
}

