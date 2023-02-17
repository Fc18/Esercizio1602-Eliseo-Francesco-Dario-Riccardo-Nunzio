package esercizio;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aula3 {

	public static void main(String[] args) {
		try {
			
			//Punto 1
			
			//Stampa in console.
			System.out.println("Inserisci il nome del file");
			//Istruzioni per eseguire l'input.
			Scanner input = new Scanner(System.in);
			//Leggere le informazioni.
			String nomeFile = input.nextLine();
			
			//Dichiarazione per fare delle operazioni sui file.
			File file = new File(nomeFile+".txt");
			
			//Verifichiamo se il file esiste o meno.
			if(!file.exists()) {
				//Creazione del file.
				FileWriter scritturaFile = new FileWriter(file);
				//Stampa di successo
				System.out.println("File creato correttamente, con il nome: "+nomeFile+".txt");
			
				//Punto 2
				System.out.print("Scrivi una frase che andrà all'intero del file: ");
				//Istruzione per ricavare le informazioni che immettiamo nella console.
				String frase = input.nextLine();
						
				//Istruzione per scrivere all interno del file
				scritturaFile.write(frase);
				
				//Chiudiamo la scrittura
				scritturaFile.close();
				
				//Stampa di successo
				System.out.println("Scrittura del file avvenuta con successo.");
				
				//Punto 3
				//Stampa avvio lettura
				System.out.println("\n Lettura del file in corso... \n");
				
				//Inizializzazione per leggere il file
				FileInputStream fileStream = new FileInputStream(file);
				InputStreamReader in = new InputStreamReader(fileStream);
				BufferedReader reader = new BufferedReader(in);
				
				//Stringa che conterrà la singola riga del file
				String linea;
				String tmp = "";
				//i è un contatore che servirà per capire in quale riga ci troviamo 
				int i = 1;
				//ciclo per leggere le singole righe del file
				while((linea = reader.readLine()) != null) {
					tmp += linea;
					System.out.println(i+". " + linea);
					i++;
				}

				reader.close();
				
				//Stampa con successo
				System.out.println("Lettura e Stampa avvenuta con successo!!");
				
				
				//Punto 4
				System.out.println("Modifica del file in corso...");
				//contains metodo per vedere se nel contenuto del file c'è almeno una lettera a così da ripiazzarla
				if(tmp.contains("a")) {
					//replaceAll server per rimpiazzare tutte le a in minuscolo a maiuscolo
					tmp = tmp.replaceAll("a", "A");
					
					//Ricreiamo un nuovo oggetto di tipo file
					File file1 = new File(nomeFile+".txt");
					FileWriter scrittura2 = new FileWriter(file1);
					//Scrivimo nel file il nuovo contenuto modificato!
					scrittura2.write(tmp);
					//Chiudiamo la scrittura.
					scrittura2.close();
					

					System.out.println("Modifica avvenuta con successo!!");
				}
				else System.out.println("Non abbiamo nessuna lettere a quindi modifica non andata a buon fine!!");

				
			}
			//Se il file esiste facciamo una stampa nell'else.
			else System.out.println("Il File esiste già!");
				
			
			
			
			
		//Il catch incapsula un errore generico e lo stampiamo in console con printStackTrace.	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
