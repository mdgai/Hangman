package com.hangman.guiMainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuFrame extends JPanel {

	/**
	 * Creates the panel for the Menu.
	 */
	public MenuFrame() {

		this.setSize(80, 25);
		this.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 23);
		this.add(menuBar);

		JMenu mnMenu = new JMenu("Game");
		menuBar.add(mnMenu);

		JMenuItem mnNewGame = new JMenuItem("New Game");
		mnMenu.add(mnNewGame);

		JMenuItem mnChangePlayer = new JMenuItem("Change player");
		mnMenu.add(mnChangePlayer);

		JMenuItem mnChangeCategory = new JMenuItem("Change category");
		mnMenu.add(mnChangeCategory);

		JMenuItem mnHighScores = new JMenuItem("High Scores");
		mnMenu.add(mnHighScores);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mnInstructions = new JMenuItem("Rules");
		mnHelp.add(mnInstructions);

		JMenuItem mnInfos = new JMenuItem("About Hangman...");
		mnHelp.add(mnInfos);

	}

}
