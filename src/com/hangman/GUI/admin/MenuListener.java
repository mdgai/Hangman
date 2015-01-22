package com.hangman.GUI.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.hangman.GUI.CategoriesGUI;

/**
 * This is an implementation of ActionListener for menu items of class Admin.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class MenuListener implements ActionListener {

	private JFrame frame;
	private JPanel contentPane;
	private JMenuItem mntmPhrase;
	private JMenuItem mntmCategory;
	private JMenuItem mntmPlayGame;
	private JMenuItem mntmAbout;

	public MenuListener(JFrame frame, JPanel contentPane, JMenuItem mntmPhrase,
			JMenuItem mntmCategory, JMenuItem mntmPlayGame, JMenuItem mntmAbout) {
		super();
		this.frame = frame;
		this.contentPane = contentPane;
		this.mntmPhrase = mntmPhrase;
		this.mntmCategory = mntmCategory;
		this.mntmPlayGame = mntmPlayGame;
		this.mntmAbout = mntmAbout;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmPhrase) {

			contentPane = new Phrase();
			frame.setContentPane(contentPane);
		}
		if (e.getSource() == mntmCategory) {

			contentPane = new Category();
			frame.setContentPane(contentPane);
		}
		if (e.getSource() == mntmPlayGame) {
			try {
				new CategoriesGUI("Please Select a Category");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == mntmAbout) {
			new About();
		}

	}
}
