package com.hangman.guiMainFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangmanMainFrame {

	private JFrame frmHangman;
	private String phrases;
	private JPanel panelMain;

	/**
	 * Creates the application.
	 * 
	 * @author Margarita Tryfou
	 */
	public HangmanMainFrame(String word) {

		initialize(word);
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 * @author Margarita Tryfou
	 */
	private void initialize(String word) {

		phrases = word;

		// Creates the JFrame
		frmHangman = new JFrame();
		frmHangman.setResizable(false);
		frmHangman.setTitle("HangMan");
		frmHangman.getContentPane().setBackground(new Color(102, 204, 51));
		frmHangman.setBounds(100, 100, 1000, 500);
		frmHangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHangman.getContentPane().setLayout(null);

		// Creates the main Panel
		panelMain = new JPanel();
		panelMain.setBackground(new Color(102, 204, 0));
		panelMain.setBounds(0, 0, 990, 466);
		frmHangman.getContentPane().add(panelMain);
		panelMain.setLayout(null);

		// Labels that contains the hanger images
		JLabel lblhangBase = new JLabel("");
		lblhangBase.setBounds(49, 102, 41, 269);
		lblhangBase.setIcon(new ImageIcon(HangmanMainFrame.class
				.getResource("/com/hangman/data/hangBase.JPG")));
		panelMain.add(lblhangBase);

		JLabel lblhangTop = new JLabel("");
		lblhangTop.setBounds(49, 88, 201, 23);
		lblhangTop.setIcon(new ImageIcon(HangmanMainFrame.class
				.getResource("/com/hangman/data/hangTop.JPG")));
		panelMain.add(lblhangTop);

		// Canvas for drawing the hangman
		Canvas canvas = new Canvas();
		canvas.setBounds(150, 117, 156, 254);
		panelMain.add(canvas);

		// Creates the Menubar
		MenuFrame menubar = new MenuFrame();
		menubar.setBounds(0, 0, 89, 23);
		panelMain.add(menubar);

		// Creates the panel for phrases
		PhrasePanel phrasePanel = new PhrasePanel(phrases);
		phrasePanel.setBackground(new Color(102, 204, 0));
		phrasePanel.setBounds(475, 130, 505, 110);
		panelMain.add(phrasePanel);

		// creates the keyboard
		KeyBoardPanel keyBoard = new KeyBoardPanel(phrasePanel);
		keyBoard.setBackground(new Color(102, 204, 0));
		keyBoard.setBounds(500, 290, 340, 118);
		panelMain.add(keyBoard);

		// Score and Lives labels
		JLabel lblLives = new JLabel("Lives:");
		lblLives.setBounds(500, 28, 68, 33);
		lblLives.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelMain.add(lblLives);

		JLabel lblTrackLives = new JLabel("6");
		lblTrackLives.setBounds(578, 28, 30, 33);
		lblTrackLives.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelMain.add(lblTrackLives);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(703, 28, 77, 33);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelMain.add(lblScore);

		JLabel label_1 = new JLabel("0");
		label_1.setBounds(783, 28, 105, 33);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelMain.add(label_1);

		frmHangman.setVisible(true);

	}
}
