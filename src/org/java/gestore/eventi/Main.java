package org.java.gestore.eventi;

import java.time.LocalDate;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataStr, formatter);

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
				
				for (int i = 0; i < numDisd; i++) {
					evento.disdici();
				}
				System.out.printf("Hai disdetto %s posti\n", numDisd);

			} else {
				System.out.println("Hai scelto di non disdire alcuna prenotazione.");
			}
			
			
		} else {
			System.out.println("Hai inserito una data già passata.");
		}
	}

}
