package registarfilmova.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import registarfilmova.Film;

/**
 * Klasa predtsavlja sistemsku operaciju za ucitavanje filma
 * @author Natasa Vatres 10/14
 * 			Valentina Andjelkovic 1/14
 *
 */
public class SOucitajFilm {

	/**
	 * Staticka metoda koja omogucava ucitavanje podataka iz fajla
	 * @param putanja
	 * @param filmovi
	 * @throws java.lang.RuntimeException ukoliko je doslo do greske prilikom deserijalizacije podataka
	 
	 */
	public static void izvrsi(String putanja, LinkedList<Film> filmovi) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));
			filmovi.clear();
			try{
				while(true){
					Film f = (Film) in.readObject();
					filmovi.add(f);
				}
			}catch(EOFException e){
					
				}
				in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
