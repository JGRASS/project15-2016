package registarfilmova;

import java.io.Serializable;

public class Film implements Serializable{

	private int id;
	private String naziv;
	private String reditelj;
	private int godina;
	private double prosecnaOcena;
	private int brojOcena;
	private Zanr zanr;
	
	public Film(int id, String naziv, String reditelj, int godina, Zanr zanr) {
		this.id = id;
		this.naziv = naziv;
		this.reditelj = reditelj;
		this.godina = godina;
		this.setZanr(zanr);
	}
	
	public Film(){
		
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

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public int getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(int brojOcena) {
		this.brojOcena = brojOcena;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

}
