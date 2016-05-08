package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import registarfilmova.Film;
import registarfilmova.RegistarFilmova;
import registarfilmova.model.RegistarFilmovaTableModel;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnFilmovi;
	private JMenuItem mntmNoviFilm;
	private JMenuItem mntmOceniFilm;
	private JMenuItem mntmOAutorima;
	private JLabel lblDobroDosliU;
	private JTable table;
	private JScrollPane scrollPane;
	private JMenuItem mntmObrisiFilm;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 380);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblDobroDosliU(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnFilmovi());
			menuBar.add(getMnNewMenu_2());
		}
		return menuBar;
	}

	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmOpen());
			mnNewMenu.add(getMntmSave());
			mnNewMenu.add(getMntmExit());
		}
		return mnNewMenu;
	}

	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("About");
			mnNewMenu_2.add(getMntmOAutorima());
		}
		return mnNewMenu_2;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ucitajFilm();
				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajFilm();
				}
			});
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}

	private JMenu getMnFilmovi() {
		if (mnFilmovi == null) {
			mnFilmovi = new JMenu("Filmovi");
			mnFilmovi.add(getMntmNoviFilm());
			mnFilmovi.add(getMntmObrisiFilm());
			mnFilmovi.add(getMntmOceniFilm());
		}
		return mnFilmovi;
	}

	private JMenuItem getMntmNoviFilm() {
		if (mntmNoviFilm == null) {
			mntmNoviFilm = new JMenuItem("Novi film");
			mntmNoviFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziProzorDodajFilm();
				}
			});
			mntmNoviFilm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmNoviFilm;
	}

	private JMenuItem getMntmOceniFilm() {
		if (mntmOceniFilm == null) {
			mntmOceniFilm = new JMenuItem("Oceni film");
			mntmOceniFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziProzorOceniFilm();
				}
			});
			mntmOceniFilm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		}
		return mntmOceniFilm;
	}

	private JMenuItem getMntmOAutorima() {
		if (mntmOAutorima == null) {
			mntmOAutorima = new JMenuItem("O Autorima");
			mntmOAutorima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziInformacije();
				}
			});
		}
		return mntmOAutorima;
	}

	private JLabel getLblDobroDosliU() {
		if (lblDobroDosliU == null) {
			lblDobroDosliU = new JLabel("Dobro dosli u Registar Filmova");
			lblDobroDosliU.setHorizontalAlignment(SwingConstants.CENTER);
			lblDobroDosliU.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblDobroDosliU;
	}

	public void osveziTabelu() {
		RegistarFilmovaTableModel model = (RegistarFilmovaTableModel) table.getModel();
		model.osveziTabelu(GUIKontroler.vratiListuFilmova());
	}

	/*
	 * protected void prikaziListuFilmova(LinkedList<Film> filmovi) {
	 * list.setListData(filmovi.toArray()); }
	 */

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		RegistarFilmovaTableModel model = new RegistarFilmovaTableModel(null);
		table.setModel(model);
		return table;
	}

	private JMenuItem getMntmObrisiFilm() {
		if (mntmObrisiFilm == null) {
			mntmObrisiFilm = new JMenuItem("Obrisi film");
			mntmObrisiFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						int index = table.getSelectedRow();
						if (index == -1) {
							GUIKontroler.porukaGreskeBiranjeReda();
						} else {
							int opcija = JOptionPane.showConfirmDialog(null,
									"Da li ste sigurni da zelite da izbrisete izbrani film?", "Poruka",
									JOptionPane.YES_NO_OPTION);
							if (opcija == JOptionPane.YES_OPTION) {
								RegistarFilmovaTableModel model = (RegistarFilmovaTableModel) table.getModel();
								Film f = model.getFilmByIndex(index);
								GUIKontroler.obrisiFilm(f);
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
					}

				}
			});
			mntmObrisiFilm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		}
		return mntmObrisiFilm;
	}
}
