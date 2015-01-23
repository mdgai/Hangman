package com.hangman.guiMainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JDialog AboutHangmanDialog Creation for the HangmanMainFrame Menu
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class AboutHangmanDialog extends JDialog {
	private JDialog contentPane;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the Dialog.
	 */
	public AboutHangmanDialog() {

		initialize();
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {

		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 493, 300);
		setBackground(new Color(102, 204, 0));
		setForeground(new Color(102, 204, 0));
		getContentPane().setLayout(new BorderLayout());
		// contentPanel.setEnabled(false);
		contentPanel.setForeground(new Color(102, 204, 0));
		contentPanel.setBackground(new Color(102, 204, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JEditorPane dtrpnTheRulesOf = new JEditorPane();
			dtrpnTheRulesOf.setEditable(false);
			dtrpnTheRulesOf.setFont(new Font("Dialog", Font.BOLD, 15));
			dtrpnTheRulesOf.setForeground(new Color(0, 102, 102));
			dtrpnTheRulesOf.setBackground(new Color(102, 204, 0));
			dtrpnTheRulesOf
					.setText("The origins of Hangman are obscure, but it seems to have arisen in Victorian times, says Tony Augarde, author of <<The Oxford Guide to Word Games>> (Oxford University Press). The game is mentioned in Alice Bertha Gomme's <<Traditional Games>> in 1894 under the name <<Birds, Beasts and Fishes.>> In the English language, the twelve most commonly occurring letters are, in descending order: e-t-a-o-i-n-s-h-r-d-l-u. This and other letter-frequency lists are used by the guessing player to increase the odds when it is their turn to guess. ");
			contentPanel.add(dtrpnTheRulesOf, BorderLayout.CENTER);
		}
		{
			JButton okButton = new JButton("OK");
			contentPanel.add(okButton, BorderLayout.SOUTH);
			okButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
			okButton.setBackground(new Color(102, 204, 0));
			okButton.setForeground(new Color(0, 102, 102));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					;
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(102, 204, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
