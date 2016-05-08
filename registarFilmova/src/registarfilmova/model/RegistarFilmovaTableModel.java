package registarfilmova.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import registarfilmova.Film;

/**
 * Klasa nasledjuje AbstractTableModel i omogucava nam da sami kreiramo svoju tabelu
 * @author Natasa Vatres 10/14
 * 			Valentina Andjelkovic 1/14
 *
 */
public class RegistarFilmovaTableModel extends AbstractTableModel{
	
	// niz stringova koja predstavlja nazive kolona tabele
	private final String[] kolone={"ID", "Naziv filma", "Reditelj", "Zanr", "Godina", "Prosecna ocena"};
	// lista filmova
	private LinkedList<Film> filmovi;
	
	
	/**
	 * Konstruktor koji inicijalizuje listu filmova 
	 * @param filmovi
	 */
	public RegistarFilmovaTableModel(LinkedList<Film> filmovi) {
		if (filmovi == null) {
			this.filmovi = new LinkedList<>();
		} else {
			this.filmovi = filmovi;
		}
	}
	
	
	@Override
	public int getRowCount() {
				return filmovi.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		switch (kolona) {
		case 0: return filmovi.get(red).getId();
		case 1: return filmovi.get(red).getNaziv();
		case 2: return filmovi.get(red).getReditelj();
		case 3: return filmovi.get(red).getZanr();
		case 4: return filmovi.get(red).getGodina();
		case 5: return filmovi.get(red).getProsecnaOcena();

		default: return "NN";
	
		}
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	
	/*
	 * Azuriranje tabelu
	 */
	public void osveziTabelu(LinkedList<Film> f){
		filmovi=f;
		fireTableDataChanged();
	}
	
	@Override
	public String getColumnName(int arg0) {
	
		return kolone[arg0];
	}
	
	/**
	 * Vraca film prosledjenog reda tabele
	 * @param index
	 * @return film
	 */
	public Film getFilmByIndex(int index){
		return filmovi.get(index);
	}
}
