package registarfilmova;

import java.util.GregorianCalendar;

public class Film {

	private int id;
	private String naziv;
	private String reditelj;
	private int godina;
	private int ocena;

	public Film(int id, String naziv, String reditelj, int godina, int ocena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.reditelj = reditelj;
		this.godina = godina;
		this.ocena = ocena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getReditelj() {
		return reditelj;
	}

	public void setReditelj(String reditelj) {
		this.reditelj = reditelj;
	}
	
	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

}
