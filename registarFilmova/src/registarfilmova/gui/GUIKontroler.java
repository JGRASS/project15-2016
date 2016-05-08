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

	public static LinkedList<Film> vratiListuFilmova() {
		return registarFilmova.vratiSveFilmove();

	}

	public static void prikaziProzorDodajFilm() {
		prozorDodajFilm.setLocationRelativeTo(glavniProzor.getContentPane());
		prozorDodajFilm.setVisible(true);

	}

	public static void dodajFilm(String naziv, int id, String reditelj, int godina, Zanr zanr) {
		try {
			Film f = new Film();
			f.setId(id);
			f.setNaziv(naziv);
			f.setReditelj(reditelj);
			f.setGodina(godina);
			f.setZanr(zanr);
			registarFilmova.unesiFilm(f);
			glavniProzor.osveziTabelu();
		} catch (Exception e) {
			prozorDodajFilm.dispose();
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void prikaziInformacije() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
				"Autors: Valentina Andjelkovic 1/14 \n  Natasa Vatres 10/14", "About", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void zatvoriAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz aplikacije?", "Exit", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public static void ucitajFilm() {
		try {
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showOpenDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				registarFilmova.ucitajFilm(file.getAbsolutePath());

				glavniProzor.osveziTabelu();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@SuppressWarnings("unchecked")
	public static void prikaziProzorOceniFilm() {
		if (registarFilmova.vratiSveFilmove().isEmpty()) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Lista filmova je prazna", "Greska",
					JOptionPane.ERROR_MESSAGE);
		} else {
			
			for (Film f : GUIKontroler.vratiListuFilmova()) {
				prozorOceniFilm.getFilmBox().addItem("" + f.getId() + " - " + f.getNaziv());
			}
			
			prozorOceniFilm.setLocationRelativeTo(glavniProzor.getContentPane());
			prozorOceniFilm.setVisible(true);

		}
	}

	public static void sacuvajFilm() {
		try {
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showSaveDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				
				registarFilmova.sacuvajFilm(file.getAbsolutePath());			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void obrisiFilm(Film f) {
		registarFilmova.obrisiFilm(f);
		glavniProzor.osveziTabelu();
	}

	public static void porukaGreskeBiranjeReda() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), "Izaberite film za brisanje!", "Greska",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void oceniFilm(int id, int ocena) {
		registarFilmova.oceniFilm(id, ocena);
		prozorOceniFilm.getFilmBox().removeAllItems();
	}

	

}
