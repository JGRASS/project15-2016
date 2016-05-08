package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;
/**
 * Klasa predstavlja sistemsku operaciju za unos filma
 * @author Natasa Vatres 10/14
 * 		Valentina Andjelkovic 1/14
 *
 */
public class SOunesiFilm {
	
	/**
	 * Staticka metoda za unos novog filma u listu filmova
	 * @param f
	 * @param filmovi
	 * @throws java.lang.RuntimeException ukoliko prosledjeni film
	 * <ul>
	 * 		<li> null </li>
	 * 		<li> vec postoji u listi </li>
	 * 		
	 * </ul>
	 */
	public static void izvrsi(Film f, LinkedList<Film> filmovi) {
		if (f == null || filmovi.contains(f))
			throw new RuntimeException("Greska pri unosu filma");

		filmovi.add(f);
	}
	
}
