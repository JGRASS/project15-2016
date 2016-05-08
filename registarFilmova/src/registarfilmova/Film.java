package registarfilmova;

import java.io.Serializable;
/**
 * Klasa koja predstavlja film
 * @author Valentina Andjelkovic 1/14,
 * 			 Natasa Vatres 10/14
 * 
 */


public class Film implements Serializable{

	// atribut koji predstavlja jedinstveni identifikator filma
	private int id;
	
	// atribut koji sadzrzi podatak o nazivu filma
	private String naziv;
	
	// atribut koji sadrzi podatak o reditelju filma
	private String reditelj;
	
	// atribut koji sadrzi podatak o godini kad je film snimljen
	private int godina;
	
	// atribut koji sadrzi podatak o tome kako je film ocenjen
	private double prosecnaOcena;
	
	// atribut koji sadrzi podatak o tome koliko puta je film ocenjen
	private int brojOcena;
	
	// atribut koji sadrzi podatak o zanru filma
	private Zanr zanr;
	
	
	/** Parametrizovani kontruktor
	 * @param id
	 * @param naziv
	 * @param reditelj
	 * @param godina
	 * @param zanr
	 */
	public Film(int id, String naziv, String reditelj, int godina, Zanr zanr) {
		this.id = id;
		this.naziv = naziv;
		this.reditelj = reditelj;
		this.godina = godina;
		this.setZanr(zanr);
	}
	
	public Film(){
		
	}

	/**
	 * Vraca celobrojnu vrednost id
	 * @return id 
	 */
	public int getId() {
		return id;
	}
    
	/** 
	 * Postavlja vrednost atributa ID
	 * @param id
	 * @throws java.lang.RuntimeException ukoliko je ID
	 * <ul>
	 * 		<li> negativan </li>
	 * 		
	 * </ul>
	 */
	public void setId(int id) {
		if(id<0){
			throw new RuntimeException("Greska pri unosu ID-a filma!");
		}
		this.id = id;
	}

	/**
	 * Vraca vrednost atributa naziv
	 * @return naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Postavlja vrednost atributa naziv 
	 * @param naziv
	 * @throws java.lang.RuntimeException ukoliko je naziv filma
	 * <ul>
	 * 		<li> null </li>
	 * 		<li> prazan string </li>
	 * 		
	 * </ul>
	 * 
	 */
	public void setNaziv(String naziv) {
		if(naziv==null || naziv.equals("")){
			throw new RuntimeException("Greska pri unosu naziva filma!");
		}
		this.naziv = naziv;
	}

	/**
	 * Vraca vrednost atributa reditelj
	 * @return
	 */
	public String getReditelj() {
		return reditelj;
	}

	/**
	 * Postavlja vrednost atributa reditelj
	 * @param reditelj
	 * @throws java.lang.RuntimeException ukoliko je reditelj
	 * <ul>
	 * 		<li> null </li>
	 * 		<li> prazan string </li>
	 * 		
	 * </ul>
	 * 
	 */
	public void setReditelj(String reditelj) {
		if(reditelj==null || reditelj.equals("")) {
		 throw new RuntimeException("Greska pri unosu reditelja filma!");
		}
		this.reditelj = reditelj;
	}

	/**
	 * Vraca vrednost atributa godina
	 * @return godina
	 */
	public int getGodina() {
		return godina;
	}

	/**
	 * Postavlja vrednost atributa godina
	 * @param godina
	 * @throws java.lang.RuntimeException ukoliko je godina
	 * <ul>
	 * 		<li> ispod 1892. godine </li>
	 * 		<li> preko 2016. godine </li>
	 * 		
	 * </ul>
	 */
	public void setGodina(int godina) {
		if(godina<1892 || godina>2016){
			throw new RuntimeException("Greska pri unosu godine!");
		}
		this.godina = godina;
	}

	/**
	 * Vraca vrednost atributa ocena
	 * @return ocena
	 */
	public int getBrojOcena() {
		return brojOcena;
	}

	/**
	 * Postavlja vrednost atributa brojOcena
	 * @param brojOcena
	 * @throws java.lang.RuntimeException ukoliko je broj ocena
	 * <ul>
	 * 		<li> manji od nule </li>
	 * 		
	 * 		
	 * </ul>
	 */
	public void setBrojOcena(int brojOcena) {
		if(brojOcena<0){
			throw new RuntimeException("Greska, broj ocena ne moze biti negativan broj!");
		}
		this.brojOcena = brojOcena;
	}

	/**
	 * Vraca vrednost atributa prosecnaOcena
	 * @return prosecnaOcena
	 */
	public double getProsecnaOcena() {
		return prosecnaOcena;
	}
	
	/**
	 * Postavlja vrednost atributa prosecnaOcena
	 * @param prosecnaOcena
	 * @throws java.lang.RuntimeException ukoliko je prosecna ocena
	 * <ul>
	 * 		<li> manji od nule </li>
	 * 		
	 * 		
	 * </ul>
	 */
	public void setProsecnaOcena(double prosecnaOcena) {
	if(prosecnaOcena<0){
		throw new RuntimeException("Greska, prosecna ocena ne moze biti negativan broj!");
	}
		this.prosecnaOcena = prosecnaOcena;
	}

	/**
	 * Vraca vrednost atributa zanr
	 * @return zanr
	 */
	public Zanr getZanr() {
		return zanr;
	}

	/**
	 * Postavlja vrednost atributa zanr
	 * @param zanr
	 * @throws java.lang.RuntimeException ukoliko je zanr
	 * <ul>
	 * 		<li> null </li>
	 * 		
	 * 		
	 * </ul>
	 */
	public void setZanr(Zanr zanr) {
		if(zanr==null){
			throw new RuntimeException("Greska pri unosu zanra filma");
		}
		this.zanr = zanr;
	}

}
