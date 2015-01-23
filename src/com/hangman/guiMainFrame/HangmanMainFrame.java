package com.hangman.guiMainFrame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangmanMainFrame {

	static JFrame frmHangman;
	private String phrases;
	private JPanel panelMain;
	private String phraseHelp;

	/**
	 * Constructor
	 * 
	 * @author Margarita Tryfou
	 */
	public HangmanMainFrame(String phrases, String phraseHelp) {

		this.phraseHelp = phraseHelp;
		this.phrases = phrases;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 * @author Margarita Tryfou
	 */
	private void initialize() {

		// Creates the JFrame
		frmHangman = new JFrame();
		frmHangman.setResizable(false);
		frmHangman.setTitle("HangMan");
		frmHangman.getContentPane().setBackground(new Color(102, 204, 51));
		frmHangman.setBounds(100, 100, 1000, 600);
		frmHangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHangman.getContentPane().setLayout(null);

		// Creates the main Panel
		panelMain = new JPanel();
		panelMain.setBackground(new Color(102, 204, 0));
		panelMain.setBounds(0, 0, 992, 566);
		frmHangman.getContentPane().add(panelMain);
		panelMain.setLayout(null);

		// Labels that contains the hanger images
		JLabel lblhangBase = new JLabel("");
		lblhangBase.setBounds(48, 208, 41, 269);
		lblhangBase.setIcon(new ImageIcon(HangmanMainFrame.class
				.getResource("/com/hangman/data/hangBase.JPG")));
		panelMain.add(lblhangBase);

		JLabel lblhangTop = new JLabel("");
		lblhangTop.setBounds(48, 194, 201, 23);
		lblhangTop.setIcon(new ImageIcon(HangmanMainFrame.class
				.getResource("/com/hangman/data/hangTop.JPG")));
		panelMain.add(lblhangTop);

		// Creates the Menubar
		MenuFrame menubar = new MenuFrame();
		MenuItemsHandler newHandler = new MenuItemsHandler();
		menubar.setBounds(0, 0, 89, 23);
		panelMain.add(menubar);

		// Creates the panel for phrases
		PhrasePanel phrasePanel = new PhrasePanel(phrases);
		phrasePanel.setBackground(new Color(102, 204, 0));
		phrasePanel.setBounds(500, 245, 480, 110);
		panelMain.add(phrasePanel);

		// Creates the Score and Lives labels
		LivesScorePanel livesScore = new LivesScorePanel();
		livesScore.setSize(386, 80);
		livesScore.setLocation(48, 53);
		livesScore.setBackground(new Color(102, 204, 0));
		panelMain.add(livesScore);

		// Canvas for drawing the hangman
		HangmanCanvas canvas = new HangmanCanvas(livesScore);
		canvas.setBounds(141, 223, 160, 250);
		panelMain.add(canvas);

		// Creates the help field
		HelpPhrasePanel helpPhrase = new HelpPhrasePanel(phraseHelp);
		helpPhrase.setBackground(new Color(102, 204, 0));
		helpPhrase.setBounds(500, 53, 467, 118);
		panelMain.add(helpPhrase);

		// creates the keyboard
		KeyBoardPanel keyBoard = new KeyBoardPanel(phrasePanel, livesScore,
				canvas);
		keyBoard.setBackground(new Color(102, 204, 0));
		keyBoard.setBounds(500, 400, 340, 118);
		panelMain.add(keyBoard);

		frmHangman.setVisible(true);

	}
}
