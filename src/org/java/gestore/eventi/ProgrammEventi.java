package org.java.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;

	/*Nel costruttore valorizzare il titolo, passato come parametro,
	 *  e inizializzare la lista di eventi come una nuova ArrayList*/
	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
        this.eventi = new ArrayList<>();
	}
	
	/*Aggiungere i seguenti metodi*/
	
	// un metodo che aggiunge alla lista un Evento, passato come parametro
	public void aggiungiEvento(Evento evento) {
		this.eventi.add(evento);
	}
	
	// 	un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	public List<Evento> getEventiData(LocalDate data) {
		List<Evento> eventiData = new ArrayList<>(); {
			for (Evento e : this.eventi) {
				if (e.getData().equals(data)) {
					eventiData.add(e);
				}
			}
			return eventiData;
		}
	}
	
	// 	un metodo che restituisce quanti eventi sono presenti nel programma
	public int getNumeroEventi() {
		return eventi.size();
		}
	
	// 	un metodo che svuota la lista di eventi
	public void svuotaLista() {
		this.eventi.clear();
	}
	
	/*	un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
	data1 - titolo1
	data2 - titolo2 
	*/
	@Override
	public String toString() {
		
	}
	
}
