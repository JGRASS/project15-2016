package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registarfilmova.Zanr;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Prozor za dodavanje novog filma
 * @author Natasa Vatres 10/14
 * 			Valentina Andjelkovic 1/14
 *
 */
public class GUIDodajFilm extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNazivFilma;
	private JTextField txtRediteljFilma;
	private JTextField txtGodina;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUIDodajFilm() {
		setResizable(false);
		setTitle("Dodavanje novog filma");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(6, 40, 78, 16);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(136, 34, 134, 28);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNazivFilma = new JLabel("Naziv filma:");
		lblNazivFilma.setBounds(6, 80, 101, 16);
		contentPane.add(lblNazivFilma);
		// polje za unos naziva filma
		txtNazivFilma = new JTextField();
		txtNazivFilma.setBounds(136, 74, 134, 28);
		contentPane.add(txtNazivFilma);
		txtNazivFilma.setColumns(10);
		
		JLabel lblRediteljFilma = new JLabel("Reditelj filma:");
		lblRediteljFilma.setBounds(6, 121, 101, 16);
		contentPane.add(lblRediteljFilma);
		// polje za unos reditelja
		txtRediteljFilma = new JTextField();
		txtRediteljFilma.setBounds(136, 115, 134, 28);
		contentPane.add(txtRediteljFilma);
		txtRediteljFilma.setColumns(10);
		
		JLabel lblIzaberiteZanr = new JLabel("Izaberite zanr:");
		lblIzaberiteZanr.setBounds(6, 164, 115, 16);
		contentPane.add(lblIzaberiteZanr);
		// omogucava izbor zanra filma
		final JComboBox<Zanr> comboBox = new JComboBox<Zanr>();
		comboBox.setBounds(136, 155, 134, 27);
		contentPane.add(comboBox);
		comboBox.addItem(Zanr.Akcija);
		comboBox.addItem(Zanr.Komedija);
		comboBox.addItem(Zanr.Dokumentarni);
		comboBox.addItem(Zanr.Fantastika);
		comboBox.addItem(Zanr.Drama);
		comboBox.addItem(Zanr.Triler);


		
		JLabel lblUnesiteGodinu = new JLabel("Unesite godinu: ");
		lblUnesiteGodinu.setBounds(6, 205, 115, 16);
		contentPane.add(lblUnesiteGodinu);
		// polje za unos godine
		txtGodina = new JTextField();
		txtGodina.setBounds(136, 199, 134, 28);
		contentPane.add(txtGodina);
		txtGodina.setColumns(10);
		// Proverava da li je korisnik siguran da zeli da unese novi film
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				// poziva staticku metodu za unos novog filma klase GUIKontroler
				GUIKontroler.dodajFilm(txtNazivFilma.getText(), Integer.parseInt(txtID.getText()), txtRediteljFilma.getText(), 
						Integer.parseInt(txtGodina.getText()), (Zanr)comboBox.getSelectedItem() );
				// polja za unos podataka se brisu nakon dodavanja novog filma
				obrisiPolja();
				// zatvaranje aplikacije za unos novog filma
				dispose();
				
			}

			/**
			 * Metoda za brisanje txtFields polja
			 */
			private void obrisiPolja() {
				txtNazivFilma.setText(null);
				txtGodina.setText(null);
				txtID.setText(null);
				txtRediteljFilma.setText(null);
				
			}
		});
		btnPotvrdi.setBounds(157, 243, 117, 29);
		contentPane.add(btnPotvrdi);
		
		// ukoliko je korisnik odustao od unosa novog filma prozor aplikacije za unos se zatvara, ali aplikacija nastavlja sa radom
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnOdustani.setBounds(294, 243, 117, 29);
		contentPane.add(btnOdustani);
	}
}
