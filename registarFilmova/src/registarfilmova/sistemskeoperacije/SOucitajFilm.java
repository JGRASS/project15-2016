package registarfilmova.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import registarfilmova.Film;

public class SOucitajFilm {

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
