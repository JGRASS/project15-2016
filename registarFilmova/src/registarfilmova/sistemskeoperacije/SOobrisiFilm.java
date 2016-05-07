package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

public class SOobrisiFilm {

	public static void izvrsi(Film f, LinkedList<Film> filmovi) {
		if (f == null || !filmovi.contains(f))
			throw new RuntimeException("Greska pri brisanju filma");

		filmovi.remove(f);
	}

}
