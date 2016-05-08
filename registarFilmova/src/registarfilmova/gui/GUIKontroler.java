package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registarfilmova.Film;
import registarfilmova.RegistarFilmova;
import registarfilmova.Zanr;
import registarfilmova.interfejs.RegistarFilmovaInterfejs;
import registarfilmova.sistemskeoperacije.SOsacuvajFilm;
import registarfilmova.sistemskeoperacije.SOucitajFilm;
import registarfilmova.sistemskeoperacije.SOunesiFilm;
/**
 * Vrsi kontrolu pristupa i zahteva korisnika
 * @author Valentina Andjelkovic 1/14
 * 		Natasa Vatres 10/14
 *
 */
public class GUIKontroler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static GlavniProzor glavniProzor;
	public static GUIDodajFilm prozorDodajFilm;
	public static OceniFilmGUI prozorOceniFilm;
	static RegistarFilmovaInterfejs registarFilmova;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// prilikom pokretanja aplikacije prikazuje se samo glavniProzor
					GUIKontroler frame = new GUIKontroler();
					frame.setVisible(false);
					glavniProzor = new GlavniProzor();
					prozorDodajFilm = new GUIDodajFilm();
					prozorOceniFilm = new OceniFilmGUI();
					registarFilmova = new RegistarFilmova();
					prozorDodajFilm.setVisible(false);
					prozorOceniFilm.setVisible(false);
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIKontroler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	/**
	 * Vraca listu filmova
	 * @return listu filmova
	 */
	public static LinkedList<Film> vratiListuFilmova() {
		return registarFilmova.vratiSveFilmove();

	}
	/**
	 * Prikaz prozora za dodavanje novog filma
	 */
	public static void prikaziProzorDodajFilm() {
		prozorDodajFilm.setLocationRelativeTo(glavniProzor.getContentPane());
		prozorDodajFilm.setVisible(true);

	}

	/**
	 * Implementira dodavanje novog filma
	 * @param naziv
	 * @param id
	 * @param reditelj
	 * @param godina
	 * @param zanr
	 * 
	 */
	public static void dodajFilm(String naziv, int id, String reditelj, int godina, Zanr zanr) {
		try {
			Film f = new Film();
			f.setId(id);
			f.setNaziv(naziv);
			f.setReditelj(reditelj);
			f.setGodina(godina);
			f.setZanr(zanr);
			// unos novog filma
			registarFilmova.unesiFilm(f);
			// azuriranje tabele
			glavniProzor.osveziTabelu();
		} catch (Exception e) {
			// zatvaranje prozora za dodavanje novog filma
			prozorDodajFilm.dispose();
			// prikazuje poruku o gresci
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Prikazuje korisniku podatke o autorima
	 */
	public static void prikaziInformacije() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
				"Autors: Valentina Andjelkovic 1/14 \n  Natasa Vatres 10/14", "About", JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Omogucava zatvaranje aplikacije
	 */
	public static void zatvoriAplikaciju() {
		// provera da li je korisnik siguran da zeli da napusti aplikaciju
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz aplikacije?", "Exit", JOptionPane.YES_NO_OPTION);

		
		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	/**
	 * Omogucava korisniku da ucita film sa izabrane lokacije
	 */
	public static void ucitajFilm() {
		try {
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showOpenDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
			
				registarFilmova.ucitajFilm(file.getAbsolutePath());
				
				// azuriranje tabele
				glavniProzor.osveziTabelu();
			}
		} catch (Exception e) {
			// prikaz poruke o gresci ukoliko je do nje doslo prilikom ucitavanja
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * Omogucava korisniku ocenu filma 
	 */
	public static void prikaziProzorOceniFilm() {
		if (registarFilmova.vratiSveFilmove().isEmpty()) {
			// prikaz poruke ukoliko je lista filmova prazna
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Lista filmova je prazna", "Greska",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// ukoliko lista filmova nije prazna, vrsi se popunjavanje comboBox-a filmBox sa filmovima
			for (Film f : GUIKontroler.vratiListuFilmova()) {
				prozorOceniFilm.getFilmBox().addItem("" + f.getId() + " - " + f.getNaziv());
			}
			// prikaz prozora oceni film
			prozorOceniFilm.setLocationRelativeTo(glavniProzor.getContentPane());
			prozorOceniFilm.setVisible(true);

		}
	}

	/**
	 * Omogucava korisniku da sacuva film na zeljenoj lokaciji
	 */
	public static void sacuvajFilm() {
		try {
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showSaveDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				
				registarFilmova.sacuvajFilm(file.getAbsolutePath());			}
		} catch (Exception e) {
			// prikaz poruke o gresci
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Vrsi brisanje filma i azuriranje tabele nakon izmene 
	 * @param f
	 */
	public static void obrisiFilm(Film f) {
		registarFilmova.obrisiFilm(f);
		glavniProzor.osveziTabelu();
	}

	/**
	 * Ispisuje error_message ukoliko nije selektovan red za brisanje
	 */
	public static void porukaGreskeBiranjeReda() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Izaberite film za brisanje!", "Greska",
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Omogucava korisniku ocenjivanje filma
	 * @param id
	 * @param ocena
	 */
	public static void oceniFilm(int id, int ocena) {
		registarFilmova.oceniFilm(id, ocena);
	// praznnjenje filmBox-a kako bi se izbeglo dupliranje filmova
		prozorOceniFilm.getFilmBox().removeAllItems();
	}

	

}
