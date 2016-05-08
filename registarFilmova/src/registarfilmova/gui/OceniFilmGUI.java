package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OceniFilmGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzaberiteFilm;
	private JLabel lblOceniteFilm;
	private JComboBox ocenaBox;
	private JComboBox filmBox;
	private JButton btnOceniFilm;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public OceniFilmGUI() {
		setTitle("Ocenjivanje filma");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzaberiteFilm());
		contentPane.add(getLblOceniteFilm());
		contentPane.add(getOcenaBox());
		contentPane.add(getFilmBox());
		contentPane.add(getBtnOceniFilm());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblIzaberiteFilm() {
		if (lblIzaberiteFilm == null) {
			lblIzaberiteFilm = new JLabel("Izaberite film: ");
			lblIzaberiteFilm.setBounds(66, 45, 131, 28);
		}
		return lblIzaberiteFilm;
	}
	private JLabel getLblOceniteFilm() {
		if (lblOceniteFilm == null) {
			lblOceniteFilm = new JLabel("Ocenite film: ");
			lblOceniteFilm.setBounds(66, 129, 131, 28);
		}
		return lblOceniteFilm;
	}
	private JComboBox getOcenaBox() {
		if (ocenaBox == null) {
			ocenaBox = new JComboBox();
			ocenaBox.setBounds(217, 133, 131, 20);
			for(int i=1; i<=10; i++)
				ocenaBox.addItem(""+i);
		}
		return ocenaBox;
	}
	public JComboBox getFilmBox() {
		if (filmBox == null) {
			filmBox = new JComboBox();
			filmBox.setBounds(217, 49, 131, 20);
		}
		return filmBox;
	}
	private JButton getBtnOceniFilm() {
		if (btnOceniFilm == null) {
			btnOceniFilm = new JButton("Oceni film");
			btnOceniFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						String film = filmBox.getSelectedItem().toString();
						String[] podela = film.split("-");
						int id = Integer.parseInt(podela[0].trim());
						
						int ocena = Integer.parseInt(ocenaBox.getSelectedItem().toString());
						
						GUIKontroler.oceniFilm(id, ocena);
						JOptionPane.showMessageDialog(null, "Uspesno ste ocenili film.");
						dispose();
					} catch(Exception ex){
						JOptionPane.showMessageDialog(null, "Doslo je do greske.");
						dispose();
					}

				}
			});
			btnOceniFilm.setBounds(54, 206, 131, 23);
		}
		return btnOceniFilm;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					getFilmBox().removeAllItems();

				}
			});
			btnOdustani.setBounds(230, 206, 131, 23);
		}
		return btnOdustani;
	}
}
