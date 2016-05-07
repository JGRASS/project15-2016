package registarfilmova.sistemskeoperacije;

import java.util.LinkedList;

import registarfilmova.Film;

public class SOoceniFilm {

	public static void izvrsi(Film f, LinkedList<Film> filmovi) {
				double noviProsek = f.getProsecnaOcena()*f.getBrojOcena();
				noviProsek+=f.getProsecnaOcena();
				f.setBrojOcena(f.getBrojOcena()+1);
				noviProsek = noviProsek/f.getBrojOcena();
				f.setProsecnaOcena(noviProsek);
	}
	
		
}
