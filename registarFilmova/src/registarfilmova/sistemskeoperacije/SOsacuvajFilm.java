package registarfilmova.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import registarfilmova.Film;
/**
 * Klasa predstavlja sistemsku operaciju sacuvaj film
 * @author Natasa Vatres 10/14
 * 			Valentina Andjelkovic 1/14
 *
 */
public class SOsacuvajFilm {

	/**
	 * Staticka metoda koja omogucuje cuvanje filma u fajl
	 * @param putanja
	 * @param filmovi
	 * @throws java.lang.RuntimeException ukoliko dodje do greske prilikom serijalizacije podataka 
	 *
	 */
	public static void izvrsi(String putanja, LinkedList<Film> filmovi) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));
			for (int i = 0; i < filmovi.size(); i++) {
				out.writeObject(filmovi.get(i));
			}
		
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
