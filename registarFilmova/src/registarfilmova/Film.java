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
		if(id<0){
			throw new RuntimeException("Greska pri unosu ID-a filma!");
		}
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv==null || naziv.equals("")){
			throw new RuntimeException("Greska pri unosu naziva filma!");
		}
		this.naziv = naziv;
	}

	public String getReditelj() {
		return reditelj;
	}

	public void setReditelj(String reditelj) {
		if(reditelj==null || reditelj.equals("")) {
		 throw new RuntimeException("Greska pri unosu reditelja filma!");
		}
		this.reditelj = reditelj;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		if(godina<1892 || godina>2016){
			throw new RuntimeException("Greska pri unosu godine!");
		}
		this.godina = godina;
	}

	public int getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(int brojOcena) {
		if(brojOcena<0){
			throw new RuntimeException("Greska, broj ocena ne moze biti negativan broj!");
		}
		this.brojOcena = brojOcena;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
	if(prosecnaOcena<0){
		throw new RuntimeException("Greska, prosecna ocena ne moze biti negativan broj!");
	}
		this.prosecnaOcena = prosecnaOcena;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		if(zanr==null){
			throw new RuntimeException("Greska pri unosu zanra filma");
		}
		this.zanr = zanr;
	}

}
