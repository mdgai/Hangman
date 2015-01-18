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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import net.miginfocom.swing.MigLayout;

import com.hangman.jdbc.service.UserService;
import com.hangman.jdbc.to.User;

public class SubmitUserGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField fldPassword;
	private JPasswordField fldPasswordMatch;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblPasswordMatch;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel lblUsernameErr;
	private JLabel lblPasswordErr;
	private JLabel lblPasswordMatchErr;
	private JLabel lblFirstnameErr;
	private JLabel lblLastnameErr;
	private JPanel buttonPane;
	private PlainDocument document;
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
		setTitle("Create Account");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.isFocusCycleRoot();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(new MigLayout("",
				"[120px,grow][200px,grow][100px][][][][]",
				"[26][26][26][26][26][26]"));

		lblUsername = new JLabel("Username *");
		contentPanel.add(lblUsername, "cell 0 0,alignx right");

		txtUsername = new JTextField();
		contentPanel.add(txtUsername, "cell 1 0,growx");
		txtUsername.setColumns(10);

		lblUsernameErr = new JLabel("");
		contentPanel.add(lblUsernameErr, "cell 2 0");

		lblPassword = new JLabel("Password *");
		contentPanel.add(lblPassword, "cell 0 1,alignx right");

		fldPassword = new JPasswordField(10);
		contentPanel.add(fldPassword, "cell 1 1,growx");

		lblPasswordErr = new JLabel("");
		contentPanel.add(lblPasswordErr, "cell 2 1");

		lblPasswordMatch = new JLabel("Password *");
		contentPanel.add(lblPasswordMatch, "cell 0 2,alignx right");

		lblPasswordMatchErr = new JLabel("");
		contentPanel.add(lblPasswordMatchErr, "cell 2 2");

		fldPasswordMatch = new JPasswordField(10);
		contentPanel.add(fldPasswordMatch, "cell 1 2,growx");

		lblFirstnameErr = new JLabel("");
		contentPanel.add(lblFirstnameErr, "cell 2 3");

		lblFirstName = new JLabel("First name *");
		contentPanel.add(lblFirstName, "cell 0 3,alignx right");

		txtFirstname = new JTextField();
		contentPanel.add(txtFirstname, "cell 1 3,growx");
		txtFirstname.setColumns(10);

		lblLastnameErr = new JLabel("");
		contentPanel.add(lblLastnameErr, "cell 2 4");

		lblLastName = new JLabel("Last Name *");
		contentPanel.add(lblLastName, "cell 0 4,alignx right");

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

		/**
		 * Limits the password to ten characters
		 */
		document = (PlainDocument) fldPassword.getDocument();
		document.setDocumentFilter(new DocumentFilter() {

			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset,
					int length, String text, AttributeSet attrs)
					throws BadLocationException {
				String string = fb.getDocument().getText(0,
						fb.getDocument().getLength())
						+ text;

				if (string.length() <= 10) {
					super.replace(fb, offset, length, text, attrs);
				}
			}

		});

		document = (PlainDocument) fldPasswordMatch.getDocument();
		document.setDocumentFilter(new DocumentFilter() {

			@Override
			public void replace(DocumentFilter.FilterBypass fb, int offset,
					int length, String text, AttributeSet attrs)
					throws BadLocationException {
				String string = fb.getDocument().getText(0,
						fb.getDocument().getLength())
						+ text;

				if (string.length() <= 10) {
					super.replace(fb, offset, length, text, attrs);
				}
			}

		});
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
					insertUser.setPassword(new String(fldPassword.getPassword()));
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
		// event for losing focus of text field Username.
		// *********************************************************
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillTextField(txtUsername, lblUsernameErr);
			}
		});

		// *********************************************************
		// event for losing focus of text field PasswordMatch.
		// *********************************************************
		fldPasswordMatch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				String password = new String(fldPasswordMatch.getPassword());
				String match = new String(fldPassword.getPassword());

				if (!match.isEmpty()) {
					if (password.equalsIgnoreCase(match))
						lblPasswordMatchErr.setIcon(new ImageIcon(
								SubmitUserGUI.class
										.getResource("/com/hangman/data/tick_circle.png")));
					else
						lblPasswordMatchErr.setIcon(new ImageIcon(
								SubmitUserGUI.class
										.getResource("/com/hangman/data/exclamation.png")));
				}

			}
		});

		// *********************************************************
		// event for losing focus of text field FirstName.
		// *********************************************************
		txtFirstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillTextField(txtFirstname, lblFirstnameErr);
			}
		});

		// *********************************************************
		// event for losing focus of text field LastName.
		// *********************************************************
		txtLastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				fillTextField(txtLastname, lblLastnameErr);
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
		String msg = "Field(s) missing: ";
		if (txtUsername.getText().isEmpty()) {
			isOk = false;
			msg = msg + "username";
		}
		if (new String(fldPassword.getPassword()).isEmpty()
				|| new String(fldPasswordMatch.getPassword()).isEmpty()) {
			if (isOk)
				msg = msg + " password";
			else
				msg = msg + ", password";
			isOk = false;
		}
		if (txtFirstname.getText().isEmpty()) {
			if (isOk)
				msg = msg + " first name";
			else
				msg = msg + ", first name";
			isOk = false;
		}
		if (txtLastname.getText().isEmpty()) {
			if (isOk)
				msg = msg + " last name.";
			else
				msg = msg + " and last name.";
			isOk = false;
		}
		if (!new String(fldPassword.getPassword()).isEmpty()
				&& !new String(fldPasswordMatch.getPassword()).isEmpty()
				&& !new String(fldPasswordMatch.getPassword())
						.equalsIgnoreCase(new String(fldPassword.getPassword()))) {
			if (isOk)
				msg = msg + " none. \n Passwords do not match";
			else
				msg = msg + "\n Passwords do not match";
			isOk = false;
		}

		if (isOk == false) {
			DialogHelper.showWarning(contentPanel, msg, "Something went wrong");
			return isOk;
		} else
			return isOk;
	}

	/**
	 * This method checks if the text field is empty. If it is, it shows an
	 * exclamation mark, if it's not it shows a tick mark.
	 * 
	 * @param textField
	 * @param labelErr
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void fillTextField(JTextField textField, JLabel labelErr) {
		if (textField.getText().isEmpty()) {
			labelErr.setIcon(new ImageIcon(SubmitUserGUI.class
					.getResource("/com/hangman/data/exclamation.png")));
		} else
			labelErr.setIcon(new ImageIcon(SubmitUserGUI.class
					.getResource("/com/hangman/data/tick_circle.png")));

	}
}
