package com.hangman.guiMainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WinnerFrame extends JFrame {

	private JPanel contentPane;
	private JEditorPane textEditor;
	private JPanel panel;

	/**
	 * Create the frame for the winner.
	 */
	public WinnerFrame() {
		setAlwaysOnTop(true);
		setResizable(false);
		setBackground(new Color(0, 204, 255));
		setTitle("Game Over");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 299, 141);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 204, 255));
		panel.setBounds(0, 0, 290, 105);
		contentPane.add(panel);
		panel.setLayout(null);

		textEditor = new JEditorPane();
		textEditor.setBackground(new Color(0, 204, 255));
		textEditor.setText("YOU ARE A WINNER!!!");
		textEditor.setEditable(false);
		textEditor.setFont(new Font("Calibri", Font.PLAIN, 25));
		textEditor.setBounds(40, 11, 240, 37);
		panel.add(textEditor);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOk.setBounds(116, 59, 60, 23);
		panel.add(btnOk);
	}

}
