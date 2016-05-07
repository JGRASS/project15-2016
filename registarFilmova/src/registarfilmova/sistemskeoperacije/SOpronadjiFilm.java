package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;
import registarfilmova.Film;

public class SOpronadjiFilm {

	public static LinkedList<Film> izvrsi(String naziv, String reditelj, LinkedList<Film> filmovi) {

		if (naziv == null)
			throw new RuntimeException("Naziv ne sme biti null");

		LinkedList<Film> nadjeniFilmovi = new LinkedList<Film>();

		for (int i = 0; i < nadjeniFilmovi.size(); i++)
			if (filmovi.get(i).getNaziv().contains(naziv))
				nadjeniFilmovi.add(filmovi.get(i));

		return nadjeniFilmovi;
	}

}
