package com.hangman.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hangman.jdbc.service.UserService;

public class LoginGUI {

	private String username, password;
	private JFrame frame;

	/**
	 * Create the application GUI
	 */
	public LoginGUI() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @author Margarita Tryfou
	 */
	private void initialize() {

		// creates a new JFrame
		final JFrame frmHandman = new JFrame();
		frmHandman.setVisible(true);
		frmHandman.setTitle("HangMan");
		frmHandman.setBounds(100, 100, 450, 350);
		frmHandman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHandman.getContentPane().setLayout(null);

		// creates a new JPanel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 442, 316);
		frmHandman.getContentPane().add(panel);
		panel.setLayout(null);

		// creates labels
		JLabel ImageLabel = new JLabel();
		ImageLabel.setLabelFor(ImageLabel);
		ImageLabel.setBounds(0, 0, 442, 164);
		ImageLabel.setIcon(new ImageIcon(LoginGUI.class
				.getResource("/com/hangman/data/hangman2.JPG")));
		panel.add(ImageLabel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(115, 184, 70, 14);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(115, 224, 70, 14);
		panel.add(lblPassword);

		// creates textFields
		final JTextField userField = new JTextField();
		userField.setText("user");
		userField.setBounds(195, 181, 108, 20);
		panel.add(userField);
		userField.setColumns(10);

		final JPasswordField passwordField = new JPasswordField();
		passwordField.setText("guest");
		passwordField.setBounds(195, 221, 108, 20);
		panel.add(passwordField);
		passwordField.setColumns(10);

		// button creation and button ActionListener
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				username = userField.getText();
				password = String.valueOf(passwordField.getPassword());

				try {

					// Checks if user is authenticated or admin and opens next
					// GUI
					if (new UserService().isAuthenticatedUser(username,
							password)) {
						if (new UserService().isAdmin(username, password)) {
							// Open AdminGUI
							frame = new AdminGUI();
							frame.setVisible(true);
						} else {
							// Open next GUI
							frame = new CategoriesGUI(
									"Please Select a Category");
							frame.setVisible(true);
						}
						frmHandman.dispose();
					} else {
						String message = "Invalid username or password. "
								+ "Please try again.";

						DialogHelper.showError(frmHandman, message, "Hangman");

					}
				} catch (Exception e) {
					DialogHelper.showException(frmHandman, e, "Exception");
				}
			}
		});
		btnEnter.setBounds(171, 270, 89, 23);
		panel.add(btnEnter);

	}
}