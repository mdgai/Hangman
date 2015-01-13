package com.hangman.GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Initialize the contents of the frame.
 * 
 * @author Alexandra Tzanidou
 */

public class CategoriesGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame_Category_Selection_Frame
	 * 
	 * @param string
	 * 
	 * @param category
	 */
	public CategoriesGUI(String string) {

		initialize();

	}

	private void initialize() {

		// creates a new JFrame
		final JFrame frmHangmanCategory = new JFrame();
		frmHangmanCategory.setVisible(true);
		frmHangmanCategory.setTitle("Hangman's Category Selection");
		frmHangmanCategory.setBounds(100, 100, 450, 350);
		frmHangmanCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHangmanCategory.getContentPane().setLayout(null);

		// creates a new JPanel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 442, 316);
		frmHangmanCategory.getContentPane().add(panel);
		panel.setLayout(null);

		// creates label
		JLabel ImageLabel = new JLabel();
		ImageLabel.setLabelFor(ImageLabel);
		ImageLabel.setBounds(0, 0, 442, 164);
		ImageLabel.setIcon(new ImageIcon(LoginGUI.class
				.getResource("/com/hangman/data/hangman2.JPG")));
		panel.add(ImageLabel);

		// creates JComboBox
		String[] Category = { "аимицлата", "епистглг", "йимглатоцяажос",
				"тевмокоциа", "лоусийг" };
		JComboBox CategoriesCombo = new JComboBox(Category);
		CategoriesCombo.setBounds(140, 155, 200, 40);
		CategoriesCombo.setVisible(true);
		panel.add(CategoriesCombo);

		// Creates the selection button
		JButton btnDone = new JButton("Done!");
		btnDone.setBounds(180, 230, 89, 23);
		btnDone.setToolTipText("Please Select a Category from the list, and then Click me!");
		panel.add(btnDone);

	}
}
