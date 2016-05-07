package registarfilmova;

import java.io.Serializable;
import java.util.LinkedList;

import registarfilmova.interfejs.RegistarFilmovaInterfejs;
import registarfilmova.sistemskeoperacije.SOobrisiFilm;
import registarfilmova.sistemskeoperacije.SOoceniFilm;
import registarfilmova.sistemskeoperacije.SOpronadjiFilm;
import registarfilmova.sistemskeoperacije.SOsacuvajFilm;
import registarfilmova.sistemskeoperacije.SOucitajFilm;
import registarfilmova.sistemskeoperacije.SOunesiFilm;

public class RegistarFilmova implements RegistarFilmovaInterfejs, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LinkedList<Film> filmovi = new LinkedList<Film>();
	
    private static RegistarFilmova instance;
	

	public static RegistarFilmova getInstance(){
		if(instance == null)
			instance = new RegistarFilmova();
		return instance;
	}

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
