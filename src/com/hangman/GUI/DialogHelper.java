package com.hangman.GUI;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * This class provides methods for using standard JDK dialogs.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class DialogHelper {
	/**
	 * This method displays an error dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void showError(Component ownwer, String message, String title) {
		JOptionPane.showMessageDialog(ownwer, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * This method displays an info dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void showInfo(Component ownwer, String message, String title) {
		JOptionPane.showMessageDialog(ownwer, message, title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This method displays a warning dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void showWarning(Component ownwer, String message,
			String title) {
		JOptionPane.showMessageDialog(ownwer, message, title,
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * This method displays a question dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void showQuestion(Component ownwer, String message,
			String title) {
		JOptionPane.showMessageDialog(ownwer, message, title,
				JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 * This method displays a YES or NO dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static boolean showYesNo(Component owner, String message,
			String title) {
		int rc = JOptionPane.showConfirmDialog(owner, message, title,
				JOptionPane.YES_NO_OPTION);
		return rc == JOptionPane.YES_OPTION;
	}

	/**
	 * This method displays an exception dialog box.
	 * 
	 * @param ownwer
	 *            - parent component of dialog box
	 * @param message
	 *            - message to display
	 * @param title
	 *            - title of dialog box
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void showException(Component ownwer, Exception e, String title) {
		JOptionPane.showMessageDialog(ownwer, e.getMessage(), title,
				JOptionPane.ERROR_MESSAGE);
	}

}
