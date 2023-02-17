package esercizioConClassi;

import java.io.File;
import java.util.Scanner;

public class EseClassi {

	public static void main(String[] args) {
		
		//Dichiarazioni.
		Scanner input = new Scanner(System.in);
		Foglio foglio;
		
		//Facciamo inserire il nome del file all'utente
		System.out.print("Inserisci il nome del file che vuoi creare: ");
		//Prendiamo i valori da input
		String nomeFile = input.nextLine();
		
		//Creiamo l'oggetto di tipo file per vedere se esiste.
		File file = new File(nomeFile+".txt");
		
		if(!file.exists()) {
			//Instanziamo l'oggetto con il file che abbiamo dichiarato.
			foglio = new Foglio(file);
			//Chiamiamo il metodo creaFile per creare il file con il nome inserito dall'utente
			foglio.creaFile();
		}else{
			System.out.println("Il file esiste già!!");
			//Mettiamo il return così da terminare il main così non continua con le sue operazioni.
			return;
		}
		
		System.out.print("Scrivi una frase che andrà all'intero del file: ");
		//Istruzione per ricavare le informazioni che immettiamo nella console.
		String frase = input.nextLine();
		
		//Chiamiamo il metodo per scrivere all'interno del file la frase appena inserita dall'utente.
		if(foglio.scritturaFile(frase)) System.out.println("Scritta nel file avvenuta con successo!!\n");
		else System.out.println("Problemi durante la modifica, riprova...\n");
		
		
		System.out.print("Lettura del file in corso...");
		foglio.letturaFile();
		
		System.out.println("\nModifica file in corso..");
		if(foglio.modificaFile()) {
			System.out.println("\nModifica avvenuta con successo adesso stampiamo il nuovo contenuto!!");
			
			//Ristampiamo il contento così da poter vedere l'effetiva modifica.
			foglio.letturaFile();
		}else System.out.println("Problemi durante la modifica, riprova...\n");
		
		
		
		
		

	}

}
