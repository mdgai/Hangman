package com.hangman.GUI.admin;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;

import com.hangman.guiMainFrame.HangmanMainFrame;

/**
 * This class holds info for the Hangman project
 * 
 * @author Maria - Despoina Gkaintatzi
 * 
 */
public class About extends JFrame {

	private JTextPane textPane;
	private JLabel lblIcon;

	/**
	 * Create the frame.
	 */
	public About() {

		initialize();
	}

	private void initialize() {
		textPane = new JTextPane();

		// Define document styles
		StyledDocument doc = textPane.getStyledDocument();

		// Load the default style and add it as the "regular" text
		javax.swing.text.Style def = StyleContext.getDefaultStyleContext()
				.getStyle(StyleContext.DEFAULT_STYLE);
		javax.swing.text.Style regular = doc.addStyle("regular", def);

		// Create a bold style
		javax.swing.text.Style bold = doc.addStyle("bold", regular);
		StyleConstants.setBold(bold, true);

		// Create a small style
		javax.swing.text.Style small = doc.addStyle("small", regular);
		StyleConstants.setFontSize(small, 10);

		// Create a large style
		javax.swing.text.Style large = doc.addStyle("large", regular);
		StyleConstants.setFontSize(large, 20);

		// Create a superscript style
		javax.swing.text.Style superscript = doc.addStyle("superscript",
				regular);
		StyleConstants.setSuperscript(superscript, true);

		// Build the document
		try {
			doc.insertString(0, "This is a project in terms of the course:\n",
					regular);
			doc.insertString(doc.getLength(),
					"Advanced Software Engineering\n", large);
			doc.insertString(doc.getLength(), "created by the students\n",
					regular);
			doc.insertString(
					doc.getLength(),
					"Maria - Despoina Gkaintatzi\nMargarita Tryfoy\nAlexandra Tzanidou\n\n",
					bold);
			doc.insertString(
					doc.getLength(),
					"Note: We did not handle exceptions, so be careful while experimenting!\n\n\n\n",
					superscript);
			doc.insertString(
					doc.getLength(),
					"\"Knowledge is power. Information is liberating."
							+ "Education is the premise of progress, in every society, in every family.\"",
					small);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		// Build the UI
		setTitle("About Hangman");
		getContentPane().setLayout(new MigLayout("", "[484px][]", "[261px]"));
		JScrollPane scrollPane = new JScrollPane(this.textPane);
		lblIcon = new JLabel();
		getContentPane().add(scrollPane, "cell 0 0,grow");
		lblIcon.setIcon(new ImageIcon(HangmanMainFrame.class
				.getResource("/com/hangman/data/info.png")));
		getContentPane().add(lblIcon, "cell 1 0");
		textPane.setEditable(false);
		setSize(500, 320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
