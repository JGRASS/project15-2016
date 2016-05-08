package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

/**
 * Predstavlja sistemsku operaciju obrisi film
 * @author Natasa Vatres 10/14,
 * 		Valentina Andjelkovic 1/14
 *
 */

public class SOobrisiFilm {

	/**
	 * Staticka metoda koja brise film iz liste filmova
	 * @param f
	 * @param filmovi
	 * @throws java.lang.RuntimeException ukoliko je prosledjen film
	 * <ul>
	 * 		<li> null </li>
	 * 		<li> ne postoji u listi </li>
	 * 		
	 * </ul>
	 */
	public static void izvrsi(Film f, LinkedList<Film> filmovi) {
		if (f == null || !filmovi.contains(f))
			throw new RuntimeException("Greska pri brisanju filma");

		filmovi.remove(f);
	}

}
