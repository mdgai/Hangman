package com.hangman.guiMainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;

public class HelpPhrasePanel extends JPanel {

	private String phrase;
	private JEditorPane editorPane;

	/**
	 * Create the panel for help field.
	 */
	public HelpPhrasePanel(final String phrase) {

		this.phrase = phrase;
		setLayout(null);

		JButton btnNewButton = new JButton("Hint");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editorPane.setText(phrase);
			}
		});
		btnNewButton.setBounds(374, 11, 66, 23);
		add(btnNewButton);

		editorPane = new JEditorPane();
		editorPane.setForeground(new Color(0, 0, 0));
		editorPane.setFont(new Font("Calibri", Font.PLAIN, 17));
		editorPane.setBackground(new Color(102, 204, 0));
		editorPane.setEditable(false);
		editorPane.setBounds(10, 34, 430, 55);
		add(editorPane);

	}
}
