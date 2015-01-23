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
 * JDialog Rules Dialog Creation for the HangmanMainFrame Menu
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class RulesDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JDialog contentPane;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the Dialog.
	 */
	public RulesDialog() {

		initialize();
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {

		setTitle("Help");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 526, 207);
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
					.setText("The rules of the game Hangman are really simple. Your role is to guess the english word, according to the selected category. Every right letter will be displayed in the searhcing word. If you failed, one piece of Hangman will be displayed. Continue with guessing letters till you find whole word or till your Hangman is complete. We wish you good luck! ");
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
