package registarfilmova.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import registarfilmova.Film;

public class SOsacuvajFilm {

	public static void izvrsi(String putanja, LinkedList<Film> filmovi) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));
			out.writeObject(filmovi);
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
