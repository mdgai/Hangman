package com.hangman.GUI.admin;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * This is the GUI for the administrator.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class Admin extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnEdit;
	private JMenu mnPlay;
	private JMenu mnHelp;
	private JMenuItem mntmCategory;
	private JMenuItem mntmPhrase;
	private JMenuItem mntmPlayGame;
	private JMenuItem mntmAbout;

	/**
	 * Create the frame.
	 */
	public Admin() {
		initialize();
		createEvents();
	}

	/**
	 * Creates all components of the frame.
	 * 
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void initialize() {

		// Set settings of frame
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);

		// Create menuBar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Create menus
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);

		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		// Create menu items
		mntmCategory = new JMenuItem("Category");
		mntmCategory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmCategory);

		mntmPhrase = new JMenuItem("Phrase");
		mntmPhrase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
				InputEvent.CTRL_MASK));
		mnEdit.add(mntmPhrase);

		mntmPlayGame = new JMenuItem("Play Game");
		mntmPlayGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,
				InputEvent.CTRL_MASK));
		mnPlay.add(mntmPlayGame);

		mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				InputEvent.CTRL_MASK));
		mnHelp.add(mntmAbout);

		// Set frame visible
		setVisible(true);

	}

	/**
	 * Handles all events of the frame
	 * 
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void createEvents() {
		// Implementation of listener
		MenuListener menuListener = new MenuListener(this, contentPane,
				mntmPhrase, mntmCategory, mntmPlayGame, mntmAbout);

		// Connects listener to event class
		mntmPhrase.addActionListener(menuListener);
		mntmCategory.addActionListener(menuListener);
		mntmPlayGame.addActionListener(menuListener);
		mntmAbout.addActionListener(menuListener);
	}

}
