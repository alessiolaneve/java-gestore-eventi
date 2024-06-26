package org.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		/*
		 * -Creare una classe Main di test, in cui si chiede all’utente di inserire un
		 * nuovo evento con tutti i parametri.
		 */
		System.out.println("Inserisci il titolo dell'evento.");
		String titolo = scan.nextLine();

		System.out.println("Inserisci la data dell'evento nel formato dd/MM/yyyy");
		String dataStr = scan.nextLine();
		// convertire string to LocalDate
		DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataStr, formatterD);
		
		System.out.println("Inserisci il numero di posti disponibili per l'evento.");
		int numPostiTot = scan.nextInt();
		scan.nextLine();

		Evento evento = new Evento(titolo, data, numPostiTot);
		LocalDate dataCheck = evento.getData();
		if (dataCheck != null) {
			System.out.println(evento.toString());

			/*
			 * -Dopo che l’evento è stato istanziato, chiedere all’utente se e quante
			 * prenotazioni vuole fare e provare ad effettuarle, implementando opportuni
			 * controlli
			 */

			System.out.println("Vuoi prenotare dei posti per l'evento? s/n");
			String rispostaPrenota = scan.nextLine();

			if (rispostaPrenota.equalsIgnoreCase("s")) {

				System.out.println("Quanti posti vuoi prenotare?");
				int numPrenotazioni = scan.nextInt();
				scan.nextLine();

				for (int i = 0; i < numPrenotazioni; i++) {
					evento.prenota();
				}
				System.out.printf("Hai prenotato %d posti\n", numPrenotazioni);
				
			} else {
				System.out.println("Hai scelto di non effettuare prenotazioni.");
			}
			;
			int postiRimasti = evento.getNumPostiTot() - evento.getNumPostiPren();
			/* -Stampare a video il numero di posti prenotati e quelli disponibili */
			System.out.printf("Ci sono %s posti prenotati e %s ancora disponibili.", evento.getNumPostiPren(),postiRimasti);
			
			/* -Chiedere all’utente se e quanti posti vuole disdire 
			 * -Provare ad effettuare le disdette, implementando opportuni controlli
			 */
			System.out.println("\nVuoi disdire delle prenotazioni effettuate? s/n");
			String rispostaDisdici = scan.nextLine();
			
			if (rispostaDisdici.equalsIgnoreCase("s")) {
				
				System.out.println("Quante prenotazioni vuoi disdire?");
				int numDisd = scan.nextInt();
				scan.nextLine();
				
				if (numDisd > 0 && numDisd < evento.getNumPostiPren()) {
					for (int i = 0; i < numDisd; i++) {
						evento.disdici();
					}
					System.out.printf("Hai disdetto %s posti\n", numDisd);					
				} else {
					System.out.println("Hai inserito un numero di disdette errato.");
				}

			} else {
				System.out.println("Hai scelto di non disdire alcuna prenotazione.");
			}
			
			/* collegamento step 3  */
			System.out.println("\nL'evento a cui vuoi partecipare è un concerto? s/n");
			String rispostaConcerto = scan.nextLine();
			
			if (rispostaConcerto.equalsIgnoreCase("s")) {
				System.out.println("A che ora si terrà il concerto? HH:mm");
				String oraStr = scan.nextLine();
				// convertire string to LocalTime
				DateTimeFormatter formatterH = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime ora = LocalTime.parse(oraStr, formatterH);
				
				// set prezzo
				System.out.println("Inserisci il prezzo del concerto.");
				Double prezzo = scan.nextDouble();

				Concerto concerto = new Concerto(titolo, dataCheck, numPostiTot, ora, prezzo);
				
				// output concerto formattato
				System.out.println(concerto.toString());
				
			} else {
				System.out.println("Goditi l'evento!");
			}
		} else {
			System.out.println("Hai inserito una data già passata.");
		}
	}

}
