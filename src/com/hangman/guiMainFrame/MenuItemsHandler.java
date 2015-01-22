package com.hangman.guiMainFrame;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.hangman.GUI.CategoriesGUI;
import com.hangman.GUI.LoginGUI;

/**
 * MenuIemsHandler is a class for handling menu's events on HangmanMainFrame
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class MenuItemsHandler extends MenuItem implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PhraseName;
	Component hag;

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("New Game")) {
			com.hangman.GUI.CategoriesGUI.btnDone.doClick();

		} else if (command.equals("Change player")) {
			new LoginGUI();

		} else if (command.equals("Change category")) {
			com.hangman.guiMainFrame.HangmanMainFrame.frmHangman.dispose();
			try {
				new CategoriesGUI("Select Another Category");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (command.equals("Exit")) {
			com.hangman.guiMainFrame.HangmanMainFrame.frmHangman.dispose();
		} else if (command.equals("Rules")) {
			RulesDialog dialog = new RulesDialog();

		}

	}
}
