package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

public class SOunesiFilm {
	
	public static void izvrsi(Film f, LinkedList<Film> filmovi) {
		if (f == null || filmovi.contains(f))
			throw new RuntimeException("Greska pri unosu filma");

		filmovi.add(f);
	}
	
}
