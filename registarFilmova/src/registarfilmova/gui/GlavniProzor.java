package registarfilmova.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

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
	private JMenuItem mntmListaFilmova;
	private JMenuItem mntmOceniFilm;
	private JMenuItem mntmOAutorima;
	private JLabel lblDobroDosliU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 351);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLblDobroDosliU(), BorderLayout.NORTH);
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
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}
	private JMenu getMnFilmovi() {
		if (mnFilmovi == null) {
			mnFilmovi = new JMenu("Filmovi");
			mnFilmovi.add(getMntmNoviFilm());
			mnFilmovi.add(getMntmListaFilmova());
			mnFilmovi.add(getMntmOceniFilm());
		}
		return mnFilmovi;
	}
	private JMenuItem getMntmNoviFilm() {
		if (mntmNoviFilm == null) {
			mntmNoviFilm = new JMenuItem("Novi film");
			mntmNoviFilm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		}
		return mntmNoviFilm;
	}
	private JMenuItem getMntmListaFilmova() {
		if (mntmListaFilmova == null) {
			mntmListaFilmova = new JMenuItem("Lista filmova");
			mntmListaFilmova.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		}
		return mntmListaFilmova;
	}
	private JMenuItem getMntmOceniFilm() {
		if (mntmOceniFilm == null) {
			mntmOceniFilm = new JMenuItem("Oceni film");
			mntmOceniFilm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		}
		return mntmOceniFilm;
	}
	private JMenuItem getMntmOAutorima() {
		if (mntmOAutorima == null) {
			mntmOAutorima = new JMenuItem("O Autorima");
		}
		return mntmOAutorima;
	}
	private JLabel getLblDobroDosliU() {
		if (lblDobroDosliU == null) {
			lblDobroDosliU = new JLabel("Dobro dosli u Registar Filmova :D");
			lblDobroDosliU.setHorizontalAlignment(SwingConstants.CENTER);
			lblDobroDosliU.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblDobroDosliU;
	}
}
