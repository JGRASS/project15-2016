package registarfilmova;

import java.io.Serializable;
import java.util.LinkedList;

import javax.lang.model.SourceVersion;

import registarfilmova.interfejs.RegistarFilmovaInterfejs;
import registarfilmova.sistemskeoperacije.SOobrisiFilm;
import registarfilmova.sistemskeoperacije.SOoceniFilm;
import registarfilmova.sistemskeoperacije.SOpronadjiFilm;
import registarfilmova.sistemskeoperacije.SOsacuvajFilm;
import registarfilmova.sistemskeoperacije.SOucitajFilm;
import registarfilmova.sistemskeoperacije.SOunesiFilm;

public class RegistarFilmova implements RegistarFilmovaInterfejs, Serializable{
	
	private LinkedList<Film> filmovi = new LinkedList<Film>();

	@Override
	public void unesiFilm(Film f) {
		SOunesiFilm.izvrsi(f, filmovi);
	}
	
	@Override
	public void obrisiFilm(Film f) {
		SOobrisiFilm.izvrsi(f, filmovi);
	}

	@Override
	public void oceniFilm(Film f) {
		SOoceniFilm.izvrsi(f, filmovi);
	}

	@Override
	public LinkedList<Film> pronadjiFilm(String naziv, String reditelj) {
		return SOpronadjiFilm.izvrsi(naziv, reditelj, filmovi);
	}
	
	@Override
	public LinkedList<Film> vratiSveFilmove() {
		return filmovi;
	}

	@Override
	public void ucitajFilm(String putanja) {
		SOucitajFilm.izvrsi(putanja, filmovi);
	}

	@Override
	public void sacuvajFilm(String putanja) {
		SOsacuvajFilm.izvrsi(putanja, filmovi);
	}

}
