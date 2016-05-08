/**
 * 
 */
package registarfilmova;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Natasa Vatres
 *
 */
public class FilmTest {

	Film f;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		f = new Film();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		f = null;
	}

	@Test
	public void testSetIdSveOk() {
		int id = 5;
		f.setId(id);
		assertEquals(id, f.getId());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetIdNegativan() {
		f.setId(-3);
	}

	@Test
	public void testSetNazivSveOk() {
		String naziv = "Kum";
		f.setNaziv(naziv);
		assertEquals(naziv, f.getNaziv());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivNull() {
		f.setNaziv(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetNazivPrazanString() {
		f.setNaziv("");
	}
	
	@Test
	public void testSetRediteljSveOk() {
		String reditelj = "Frensis Ford Kopola";
		f.setReditelj(reditelj);
		assertEquals(reditelj, f.getReditelj());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetRediteljNull() {
		f.setReditelj(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetRediteljPrazanString() {
		f.setReditelj("");
	}
	
	@Test
	public void testSetGodinaSveOk() {
		int godina = 1973;
		f.setGodina(godina);
		assertEquals(godina, f.getGodina());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetGodinaDavno() {
		f.setGodina(1800);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetGodinaBuducnost() {
		f.setGodina(3000);
	}
	
	@Test
	public void testSetBrojOcenaSveOk() {
		int brOcena = 10;
		f.setBrojOcena(brOcena);
		assertEquals(brOcena, f.getBrojOcena());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetBrojOcenaNegativan() {
		f.setId(-3);
	}
	
	@Test
	public void testSetProsecnaOcenaSveOk() {
		int prosecnaOcena = 10;
		f.setProsecnaOcena(prosecnaOcena);
		assertEquals(prosecnaOcena, f.getProsecnaOcena());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetProsecnaOcenaNegativan() {
		f.setId(-3);
	}
	
	@Test
	public void testSetZanrSveOk() {
		Set<String> expected = new HashSet<> (Arrays.asList("Drama", "Fantastika", "Triler", "Dokumentarni", "Komedija", "Akcija"));
		Set<String> actual = new HashSet<>();
		for (Zanr e : Zanr.values()) actual.add(e.name());
		assertEquals(expected, actual);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testZanrNull() {
		f.setZanr(null);
	}

}
