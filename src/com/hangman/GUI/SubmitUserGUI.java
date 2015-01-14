package com.hangman.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import com.hangman.jdbc.service.UserService;
import com.hangman.jdbc.to.User;

public class SubmitUserGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField fldPassword;
	private JPasswordField fldPassword_1;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblPassword_1;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel lblUsernameErr;
	private JLabel lblPasswordErr;
	private JLabel lblPassword_1Err;
	private JLabel lblFirstnameErr;
	private JLabel lblLastnameErr;
	private JPanel buttonPane;
	private ImageIcon exclamation = new ImageIcon(getClass().getResource(
			"/com/hangman/data/exclamation.png"));
	private ImageIcon tick = new ImageIcon(getClass().getResource(
			"/com/hangman/data/tick_circle.png"));

	/**
	 * Create the dialog.
	 */
	public SubmitUserGUI() {
		initialize();
		createEvents();
	}

	private void initialize() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("",
				"[right][100px,grow][100px][][][][]", "[][][][][][]"));

		lblUsername = new JLabel("Username *");
		contentPanel.add(lblUsername, "cell 0 0,alignx trailing");

		txtUsername = new JTextField();
		contentPanel.add(txtUsername, "cell 1 0,growx");
		txtUsername.setColumns(10);

		lblUsernameErr = new JLabel("");
		contentPanel.add(lblUsernameErr, "cell 2 0");

		lblPassword = new JLabel("Password *");
		contentPanel.add(lblPassword, "cell 0 1,alignx trailing");

		fldPassword = new JPasswordField(10);
		contentPanel.add(fldPassword, "cell 1 1,growx");

		lblPasswordErr = new JLabel("");
		contentPanel.add(lblPasswordErr, "cell 2 1");

		lblPassword_1 = new JLabel("Password *");
		contentPanel.add(lblPassword_1, "cell 0 2,alignx trailing");

		lblPassword_1Err = new JLabel("");
		contentPanel.add(lblPassword_1Err, "cell 2 2");

		fldPassword_1 = new JPasswordField(10);
		contentPanel.add(fldPassword_1, "cell 1 2,growx");

		lblFirstnameErr = new JLabel("");
		contentPanel.add(lblFirstnameErr, "cell 2 3");

		lblFirstName = new JLabel("First name *");
		contentPanel.add(lblFirstName, "cell 0 3,alignx trailing");

		txtFirstname = new JTextField();
		contentPanel.add(txtFirstname, "cell 1 3,growx");
		txtFirstname.setColumns(10);

		lblLastnameErr = new JLabel("");
		contentPanel.add(lblLastnameErr, "cell 2 4");

		lblLastName = new JLabel("Last Name *");
		contentPanel.add(lblLastName, "cell 0 4,alignx trailing");

		txtLastname = new JTextField();
		contentPanel.add(txtLastname, "cell 1 4,growx");
		txtLastname.setColumns(10);

		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			saveButton = new JButton("Save");
			saveButton.setIcon(new ImageIcon(SubmitUserGUI.class
					.getResource("/com/hangman/data/add.png")));

			saveButton.setActionCommand("OK");
			buttonPane.add(saveButton);
			getRootPane().setDefaultButton(saveButton);
		}
		{
			cancelButton = new JButton("Cancel");
			cancelButton.setIcon(new ImageIcon(SubmitUserGUI.class
					.getResource("/com/hangman/data/cancel.png")));
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}

	// Private method that includes all events of the window.
	private void createEvents() {

		// *********************************************************
		// event for save button.
		// *********************************************************
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					User insertUser = new User();
					UserService userService = new UserService();

					insertUser.setUsername(txtUsername.getText());
					insertUser.setPassword(fldPassword.getSelectedText());
					insertUser.setFirstName(txtFirstname.getText());
					insertUser.setLastName(txtLastname.getText());
					insertUser.setAdmin(false);

					userService.add(insertUser);
					dispose();
				}
			}
		});

		// *********************************************************
		// event for cancel button.
		// *********************************************************
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// *********************************************************
		// event for losing focus of text field NAME.
		// *********************************************************
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().isEmpty())
					lblUsernameErr.setIcon(exclamation);
				else
					lblUsernameErr.setIcon(tick);
			}
		});

		// *********************************************************
		// event for losing focus of text field NAME.
		// *********************************************************
		fldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(fldPassword.getPassword());
				if (password.isEmpty()) {
					lblPasswordErr.setIcon(exclamation);
				} else
					lblPasswordErr.setIcon(tick);
			}
		});

		// *********************************************************
		// event for losing focus of text field NAME.
		// *********************************************************
		fldPassword_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(fldPassword_1.getPassword());
				if (!password.isEmpty()
						&& password.equalsIgnoreCase(new String(fldPassword
								.getPassword())))
					lblPassword_1Err.setIcon(tick);
				else
					lblPassword_1Err.setIcon(exclamation);
			}
		});

		// *********************************************************
		// event for losing focus of text field NAME.
		// *********************************************************
		txtFirstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtFirstname.getText().isEmpty())
					lblFirstnameErr.setIcon(exclamation);
				else
					lblFirstnameErr.setIcon(tick);
			}
		});

		// *********************************************************
		// event for losing focus of text field NAME.
		// *********************************************************
		txtLastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtLastname.getText().isEmpty())
					lblLastnameErr.setIcon(exclamation);
				else
					lblLastnameErr.setIcon(tick);
			}
		});

	}

	/**
	 * This method validates the form's fields.
	 * 
	 * @return true, if all fields of the form are properly filled in.
	 * @author Maria - Despoina Gkaintatzi
	 */
	private boolean validateForm() {
		Boolean isOk = true;
		if ((txtUsername.getText().isEmpty())
				|| new String(fldPassword.getPassword()).isEmpty()
				|| new String(fldPassword_1.getPassword()).isEmpty()
				|| txtFirstname.getText().isEmpty()
				|| txtLastname.getText().isEmpty()
				|| !new String(fldPassword_1.getPassword())
						.equalsIgnoreCase(new String(fldPassword.getPassword())))
			isOk = false;

		return isOk;
	}

}
