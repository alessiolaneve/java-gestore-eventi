package org.java.gestore.eventi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/* Step 2

-Stampare a video il numero di posti prenotati e quelli disponibili

-Chiedere all’utente se e quanti posti vuole disdire

-Provare ad effettuare le disdette, implementando opportuni controlli

-Stampare a video il numero di posti prenotati e quelli disponibili
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		/* -Creare una classe Main di test, in cui si chiede all’utente di inserire un nuovo evento con tutti i parametri. */
		System.out.println("Inserisci il titolo dell'evento.");
		String titolo = scan.nextLine();
		
		System.out.println("Inserisci la data dell'evento nel formato dd/MM/yyyy HH:mm.");
		String dataStr = scan.nextLine();
		// convertire string to localdatetime
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime data = LocalDateTime.parse(dataStr, formatter);
		
		System.out.println("Inserisci il numero di posti disponibili per l'evento.");
		int numPostiTot = scan.nextInt();
		scan.nextLine();
		
		Evento evento = new Evento(titolo, data, numPostiTot);
		LocalDateTime dataCheck = evento.getData();
		if (dataCheck != null) {
		System.out.println(evento.toString());
		
		/* -Dopo che l’evento è stato istanziato, chiedere all’utente se e quante prenotazioni vuole fare e 
		 * provare ad effettuarle, implementando opportuni controlli */
		
		System.out.println("Vuoi prenotare dei posti per l'evento? s/n");
		String rispostaPrenota = scan.nextLine();
		
		if (rispostaPrenota.equalsIgnoreCase("s")) {
			
			System.out.println("Quanti posti vuoi prenotare?");
			int numPrenotazioni = scan.nextInt();
			
			for (int i = 0; i < numPrenotazioni; i++) {
				evento.prenota();
			}
			System.out.printf("Hai prenotato %d posti", numPrenotazioni);
			
		} 
		else {
			System.out.println("Hai scelto di non effettuare prenotazioni.");
		};
		
		
		} else {
			System.out.println("Hai inserito una data già passata.");
		}
	}

}
