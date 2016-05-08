package registarfilmova.interfejs;

import java.util.LinkedList;

import registarfilmova.Film;

public interface RegistarFilmovaInterfejs {

	public void unesiFilm(Film f);
	public void obrisiFilm(Film f);
	public void oceniFilm(int id, int ocena);
	public LinkedList<Film> pronadjiFilm(String naziv, String reditelj);
	public LinkedList<Film> vratiSveFilmove();
	public void ucitajFilm(String putanja);
	public void sacuvajFilm(String putanja);
	
}
