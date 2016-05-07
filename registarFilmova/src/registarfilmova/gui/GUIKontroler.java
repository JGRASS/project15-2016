package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registarfilmova.Film;
import registarfilmova.RegistarFilmova;
import registarfilmova.Zanr;
import registarfilmova.interfejs.RegistarFilmovaInterfejs;
import registarfilmova.sistemskeoperacije.SOunesiFilm;

public class GUIKontroler extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static GlavniProzor glavniProzor;
	public static GUIDodajFilm prozorDodajFilm;
	static RegistarFilmovaInterfejs registarFilmova;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler frame = new GUIKontroler();
					frame.setVisible(false);
					glavniProzor= new GlavniProzor();
					prozorDodajFilm=new GUIDodajFilm();
					registarFilmova=new RegistarFilmova();
					prozorDodajFilm.setVisible(false);
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

	public static void prikaziProzorDodajFilm() {
		prozorDodajFilm.setVisible(true);
		prozorDodajFilm.setLocationRelativeTo(null);
	}

	public static void dodajFilm(String naziv, int id, String reditelj, int godina, Zanr zanr) {
		
		Film f=new Film(id, naziv, reditelj, godina, zanr);
		SOunesiFilm.izvrsi(f, registarFilmova.vratiSveFilmove());
		
	}

}
