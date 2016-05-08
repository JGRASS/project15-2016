package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;
import registarfilmova.Film;
/**
 * Klasa predstavlja sistemsku operaciju pronadji film
 * @author Natasa Vatres 10/14
 * 			Valentina Andjelkovic 1/14
 *
 */
public class SOpronadjiFilm {

	/**
	 * Staticka metoda koja pronalazi i vraca filmove sa istim nazivom
	 * @param naziv
	 * @param reditelj
	 * @param filmovi
	 * @return listu filmova
	 * @throws java.lang.RuntimeException ukoliko je prosledjeni naziv filma
	 * <ul>
	 * 		<li> null </li>
	 * 		
	 * 		
	 * </ul>
	 */
	public static LinkedList<Film> izvrsi(String naziv, String reditelj, LinkedList<Film> filmovi) {

		if (naziv == null)
			throw new RuntimeException("Naziv ne sme biti null");
		//pomocna lista gde se ubacuju pronadjeni filmovi
		LinkedList<Film> nadjeniFilmovi = new LinkedList<Film>();

		for (int i = 0; i < nadjeniFilmovi.size(); i++)
			if (filmovi.get(i).getNaziv().contains(naziv))
				nadjeniFilmovi.add(filmovi.get(i));

		return nadjeniFilmovi;
	}

}
