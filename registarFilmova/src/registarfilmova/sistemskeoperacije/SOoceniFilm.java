package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

public class SOoceniFilm {

	public static void izvrsi(int id, int d, LinkedList<Film> filmovi) {
		if(id<0 || d<0){
			throw new RuntimeException("Greska pri ocenjivanju filma!");
		}
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
