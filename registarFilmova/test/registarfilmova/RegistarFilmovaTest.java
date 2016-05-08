package registarfilmova;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Natasa Vatres
 *
 */
public class RegistarFilmovaTest {

	private RegistarFilmova registarFilmova;
	private Film f;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		registarFilmova = new RegistarFilmova();
		f = new Film(1, "Kum", "Kopola", 1973, Zanr.Drama);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		registarFilmova = null;
		f = null;
	}

	@Test
	public void unesiFilmSveOK() {
		int brEl = registarFilmova.vratiSveFilmove().size();
		registarFilmova.vratiSveFilmove().add(f);
	    assertEquals(brEl+1, registarFilmova.vratiSveFilmove().size());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiFilmNull() {
		registarFilmova.unesiFilm(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiFilmVecUnet() {
		registarFilmova.unesiFilm(f);
		registarFilmova.unesiFilm(f);
	}
	
	@Test
	public void obrisiFilmSveOK() {
		int brEl = registarFilmova.vratiSveFilmove().size();
		registarFilmova.vratiSveFilmove().remove(f);
	    assertEquals(brEl, registarFilmova.vratiSveFilmove().size());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testObrisiFilmNull() {
		registarFilmova.obrisiFilm(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testObrisiFilmNemaGa() {
		registarFilmova.obrisiFilm(f);
	}
	
	@Test
	public void oceniFilmSveOk() {
		registarFilmova.oceniFilm(1, 10);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void oceniFilmIdNegativan() {
		registarFilmova.oceniFilm(0, -3);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void oceniFilmOcenaNegativna() {
		registarFilmova.oceniFilm(-3, 0);
	}
	
	@Test
	public void ucitajFilmSveOk() {
		registarFilmova.ucitajFilm("filmovi.txt");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void ucitajFilmNull() {
		registarFilmova.ucitajFilm(null);
	}
	
	@Test
	public void sacuvajFilmSveOk() {
		registarFilmova.sacuvajFilm("filmovi.txt");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void sacuvajFilmNull() {
		registarFilmova.ucitajFilm(null);
	}
	
}
