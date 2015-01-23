package com.hangman.guiMainFrame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuFrame extends JPanel {

	private JFrame frame;
	Object newHandler;

	/**
	 * Creates the panel for the Menu.
	 * 
	 * @author Tryfou Margarita
	 */
	public MenuFrame() {

		MenuItemsHandler Handler = new MenuItemsHandler();

		this.setSize(80, 25);
		this.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 23);
		this.add(menuBar);
		MenuItemsHandler handler = new MenuItemsHandler();

		JMenu mnMenu = new JMenu("Game");
		menuBar.add(mnMenu);

		JMenuItem mnNewGame = new JMenuItem("New Game");
		mnMenu.add(mnNewGame);
		mnNewGame.addActionListener(handler);

		JMenuItem mnChangePlayer = new JMenuItem("Change player");
		mnMenu.add(mnChangePlayer);
		mnChangePlayer.addActionListener(handler);

		JMenuItem mnChangeCategory = new JMenuItem("Change category");
		mnMenu.add(mnChangeCategory);
		mnChangeCategory.addActionListener(handler);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnMenu.add(mntmExit);
		mntmExit.addActionListener(handler);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		mnHelp.addActionListener(handler);

		JMenuItem mnInstructions = new JMenuItem("Rules");
		mnHelp.add(mnInstructions);
		mnInstructions.addActionListener(handler);

		JMenuItem mnInfos = new JMenuItem("About Hangman...");
		mnHelp.add(mnInfos);
		mnInfos.addActionListener(handler);

	}

}
