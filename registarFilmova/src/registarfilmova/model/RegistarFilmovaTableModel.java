package registarfilmova.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import registarfilmova.Film;

public class RegistarFilmovaTableModel extends AbstractTableModel{
	

	private final String[] kolone={"ID", "Naziv filma","Reditelj", "Zanr","Godina", "Prosecna ocena"};
	private LinkedList<Film> filmovi;
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
	
	public Film vratiKurs(int index){
		return filmovi.get(index);
	}
	
	
	public void osveziTabelu(){
		fireTableDataChanged();

	}
	
	@Override
	public String getColumnName(int arg0) {
	
		return kolone[arg0];
	}
}
