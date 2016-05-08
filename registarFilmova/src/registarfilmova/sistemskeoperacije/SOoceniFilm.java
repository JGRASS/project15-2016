package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

public class SOoceniFilm {

	public static void izvrsi(int id, int d, LinkedList<Film> filmovi) {
		for(Film film : filmovi){
			if(film.getId() == id){
				
				double noviProsek = film.getProsecnaOcena()*film.getBrojOcena();
				noviProsek+=d;
				film.setBrojOcena(film.getBrojOcena()+1);
				noviProsek = noviProsek/(double)film.getBrojOcena();
				film.setProsecnaOcena(noviProsek);
			}
		}
	}
	
		
}
