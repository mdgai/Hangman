package com.hangman.guiMainFrame;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhrasePanel extends JPanel {
	private String phrase;
	ArrayList<JLabel> labelList = new ArrayList<JLabel>();

	/**
	 * Creates the panel.
	 * 
	 * @author Tryfou Margarita
	 */
	public PhrasePanel(String aPhrase) {

		phrase = aPhrase;
		addLabel();
		setLayout(null);
	}

	/**
	 * Class for adding Labels depending on phrase length. lblPhrase_i ->
	 * contains the phrase which has been splitted lblUnderScore_ii ->
	 * overwrites the lblPhrase_i
	 * 
	 * @author Tryfou Margarita
	 */
	public void addLabel() {

		int phrase_length = phrase.length();
		int bound_x = 0, bound_y = 0;

		for (int i = 0; i < phrase_length; i++) {
			JLabel lblPhrase_i = new JLabel();
			lblPhrase_i.setFont(new Font("Calibri", Font.BOLD, 26));
			lblPhrase_i.setBounds(bound_x, 0, 28, 36);
			lblPhrase_i.setText(phrase.substring(i, i + 1));
			labelList.add(lblPhrase_i);
			lblPhrase_i.setVisible(false);
			this.add(lblPhrase_i);

			JLabel lblUnderScore_ii = new JLabel("__");
			lblUnderScore_ii.setFont(new Font("Calibri", Font.BOLD, 26));
			lblUnderScore_ii.setBounds(bound_x, bound_y, 28, 36);
			labelList.add(lblUnderScore_ii);
			this.add(lblUnderScore_ii);
			bound_x += 40;

		}

	}

	/**
	 * Return the ArrayList labelList
	 * 
	 * @return
	 * @author Tryfou Margarita
	 */
	public ArrayList<JLabel> getLabelList() {
		return labelList;
	}

	/**
	 * Return current phrase
	 * 
	 * @return
	 * @author Tryfou Margarita
	 */
	public String getPhrase() {
		return phrase;
	}
}
