package esercizioConClassi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import java.nio.file.Paths;

public class Foglio {

	private File file;
	private FileWriter scritturaFile;
	
	public Foglio(File file) {
		this.file = file;
	}
	

	public void creaFile(){
		try {
			
		//Creaiamo il file visto che non esiste.
		scritturaFile = new FileWriter(file);
		
		//Stampa successo, ho usato il metodo getName così da farmi restituire il nome del file appena creato.
		System.out.println("Il file '" + file.getName() + "' è stato creato con successo!!\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean scritturaFile(String frase) {
		try {
			
			//Scrivimo la frase all'interno del file.
			scritturaFile.write(frase);
			//Chiudiamo l'operazione di scrittura.
			scritturaFile.close();
			scritturaFile = null;
			//Facciamo un return così che nel main possiamo vedere e stampare se la modifica è andata a buonfine o no.
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void letturaFile() {
		try {
			//Inizializzazione per leggere il file
			FileInputStream fileStream = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fileStream);
			BufferedReader reader = new BufferedReader(in);
			String riga;
			//Metodo per leggere riga per riga del nostro file
			while((riga = reader.readLine()) != null) {
				System.out.println("\nContenuto del file: "+ riga);
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Boolean modificaFile() {
		try {
			//Nuovo metodo per prendere tutto il contenuto del file senza ciclare ma solo grazie alla posizione del file e un metodo della classe Files
			String contenutoFile = Files.readString(Paths.get(file.getName()));
			
			//Verifichiamo se il contenuto del file contiene delle lettere a minuscole o no, tutto questo grazie al metodo contains
			if(contenutoFile.contains("a")) {
				//Rimpiazziamo tutte le a che sono presenti nel contenuto del file in A
				contenutoFile = contenutoFile.replaceAll("a", "A");
				//Riassegniamo il l'oggetto filewriter perché se no ci darà errore durante la scrittura.
				scritturaFile = new FileWriter(file);
				//Scriviamo il nuovo contenuto del file.
				scritturaFile.write(contenutoFile);
				//Chiudiamo il file
				scritturaFile.close();
				//Assegniamo null così che possono riutilizzare la variabile.
				scritturaFile = null;
				
			}else System.out.println("Il file non contiene della lettere a in minuscolo!!");
			
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
