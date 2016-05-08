package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;
/**
 * Predstavlja sistemsku operaciju ocene filma
 * @author Natasa Vatres 10/14,
 * 		Valentina Andjelkovic 1/14
 *
 */
public class SOoceniFilm {
	/**
	 * Staticka metoda koja ocenjuje film
	 * @param id
	 * @param d
	 * @param filmovi
	 * @throws java.lang.RuntimeException ukoliko je id ili ocena
	 * <ul>
	 * 		<li> manje od nule </li>
	 * 		
	 * 		
	 * </ul>
	 */
	public static void izvrsi(int id, int d, LinkedList<Film> filmovi) {
		if(id<0 || d<0){
			throw new RuntimeException("Greska pri ocenjivanju filma!");
		}
		// pronalazi film sa odgovarajucim atributom id
		for(Film film : filmovi){
			if(film.getId() == id){
		
				// formira novi prosek na osnovu nove unete ocene
				double noviProsek = film.getProsecnaOcena()*film.getBrojOcena();
				noviProsek+=d;
				film.setBrojOcena(film.getBrojOcena()+1);
				noviProsek = noviProsek/(double)film.getBrojOcena();
				film.setProsecnaOcena(noviProsek);
			}
		}
	}
	
		
}
