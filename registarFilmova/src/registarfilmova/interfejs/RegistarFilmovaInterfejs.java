package registarfilmova.interfejs;

import java.util.LinkedList;

import registarfilmova.Film;

/** 
 * Interfejs koji sadrzi specifikaciju registra filmova
 * @author Valentina Andjelkovic 1/14, Natasa Vatres 10/14
 *
 */
public interface RegistarFilmovaInterfejs {

	public void unesiFilm(Film f);
	public void obrisiFilm(Film f);
	public void oceniFilm(int id, int ocena);
	public LinkedList<Film> pronadjiFilm(String naziv, String reditelj);
	public LinkedList<Film> vratiSveFilmove();
	public void ucitajFilm(String putanja);
	public void sacuvajFilm(String putanja);
	
}
