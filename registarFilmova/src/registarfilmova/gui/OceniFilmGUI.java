package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import registarfilmova.Film;
import registarfilmova.sistemskeoperacije.SOoceniFilm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OceniFilmGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public OceniFilmGUI() {
		setTitle("Ocena filmova");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzaberiteFilm = new JLabel("Izaberite film");
		lblIzaberiteFilm.setBounds(52, 51, 104, 16);
		contentPane.add(lblIzaberiteFilm);
	
		final JComboBox filmBox = new JComboBox();
		filmBox.setBounds(240, 47, 159, 27);
		contentPane.add(filmBox);
		for(Film f : GUIKontroler.vratiListuFilmova()){
			filmBox.addItem(""+f.getId()+" - "+f.getNaziv());
		} 
		JLabel lblIzaberiteOcenu = new JLabel("Izaberite ocenu");
		lblIzaberiteOcenu.setBounds(52, 128, 104, 16);
		contentPane.add(lblIzaberiteOcenu);
		
		final JComboBox ocenaBox = new JComboBox();
		ocenaBox.setBounds(248, 124, 104, 27);
		contentPane.add(ocenaBox);
		for(int i=1; i<=10; i++){
			ocenaBox.addItem(""+i);
		}
		JButton btnOceni = new JButton("Oceni");
		btnOceni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					String film = filmBox.getSelectedItem().toString();
					String[] podela = film.split("-");
					int id = Integer.parseInt(podela[0].trim());
					
					int ocena = Integer.parseInt(ocenaBox.getSelectedItem().toString());
					
					// fali 
					JOptionPane.showMessageDialog(null, "Uspesno ste ocenili film.");
					dispose();
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Doslo je do greske.");
					dispose();
				}
			}
		});
		btnOceni.setBounds(181, 204, 117, 29);
		contentPane.add(btnOceni);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(327, 204, 117, 29);
		contentPane.add(btnOdustani);
	}


}
