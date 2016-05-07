package registarfilmova.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import registarfilmova.Film;

public class SOucitajFilm {

	public static void izvrsi(String putanja, LinkedList<Film> filmovi) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));
			@SuppressWarnings("unchecked")
			LinkedList<Film> filmovi2 = (LinkedList<Film>) (in.readObject());
			filmovi.clear();
			filmovi.addAll(filmovi2);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
