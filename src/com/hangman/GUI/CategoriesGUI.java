package com.hangman.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hangman.guiMainFrame.HangmanMainFrame;
import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.service.PhrasesService;
import com.hangman.jdbc.to.Category;
import com.hangman.jdbc.to.CategoryCriteria;
import com.hangman.jdbc.to.Phrases;
import com.hangman.jdbc.to.PhrasesCriteria;

/**
 * Initialize the contents of the frame.
 * 
 * @author Alexandra Tzanidou
 */

public class CategoriesGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object SelectedCategory;

	/**
	 * Create the frame_Category_Selection_Frame
	 * 
	 * @param string
	 * 
	 * @param category
	 * @throws Exception
	 */
	public CategoriesGUI(String string) throws Exception {

		initialize();

	}

	private void initialize() throws Exception {

		// creates a new JFrame
		final JFrame frmHangmanCategory = new JFrame();
		frmHangmanCategory.setVisible(true);
		frmHangmanCategory.setTitle("Hangman's Category Selection");
		frmHangmanCategory.setBounds(100, 100, 450, 350);
		frmHangmanCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHangmanCategory.getContentPane().setLayout(null);

		// creates a new JPanel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 442, 316);
		frmHangmanCategory.getContentPane().add(panel);
		panel.setLayout(null);

		// creates label
		JLabel ImageLabel = new JLabel();
		ImageLabel.setLabelFor(ImageLabel);
		ImageLabel.setBounds(0, 0, 442, 164);
		ImageLabel.setIcon(new ImageIcon(LoginGUI.class
				.getResource("/com/hangman/data/hangman2.JPG")));
		panel.add(ImageLabel);

		// Creates the combobox with database's categories
		List<Category> categoryList = new CategoryService()
				.findAll(new CategoryCriteria());
		final JComboBox CategoriesCombo = new JComboBox(
				(Category[]) categoryList.toArray(new Category[categoryList
						.size()]));
		CategoriesCombo.setVisible(true);
		CategoriesCombo.setBounds(140, 155, 200, 40);
		CategoriesCombo.setSelectedIndex(0);
		CategoriesCombo.addActionListener(this);
		CategoriesCombo.setBackground(getForeground());
		panel.add(CategoriesCombo);

		// Creates the selection button
		JButton btnDone = new JButton("Done!");
		btnDone.setBounds(180, 230, 89, 23);
		btnDone.setToolTipText("Please Select a Category from the list, and then Click me!");
		panel.add(btnDone);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CategoryCriteria fselection = new CategoryCriteria();
				PhrasesCriteria inportphrases = new PhrasesCriteria();
				try {
					/**
					 * Reads the selected category, and split the string in two
					 * different.
					 */
					Object contents = CategoriesCombo.getSelectedItem()
							.toString();

					String[] parts = ((String) contents).replaceAll("\\[", "")
							.replaceAll("\\]", "").split(" ");
					String id = parts[0];
					int idtoint = Integer.parseInt(id);
					String Name = parts[1];
					String selectionDone = new CategoryService()
							.CategorySelection(Name);
					Integer SelcategoryID = new CategoryService()
							.CategoryId(idtoint);

					PhrasesService phrasesService = new PhrasesService();
					List<Phrases> list = phrasesService.thisPhrases(idtoint);

					Random random = new Random(); // Create random class object
					/*
					 * Generate a random number (index) with the size of the
					 * list being the maximum
					 */
					int randomSelection = random.nextInt(list.size());
					/*
					 * Object with the random selection
					 */
					Object randomSelectionrow = list.get(randomSelection)
							.toString();
					String[] partsOfrandom = ((String) randomSelectionrow)
							.replaceAll("\\[", "").replaceAll("\\]", "")
							.split("\\.");
					String PhraseId = partsOfrandom[0];
					String PhraseCategoryId = partsOfrandom[1];
					String PhraseName = partsOfrandom[2];
					String PhraseHelp = partsOfrandom[3];
					// char[] WordForMainGui = PhraseName.toCharArray();
					new HangmanMainFrame(PhraseName);

					// System.out.println(contents);
					System.out.println(PhraseId);
					System.out.println(PhraseCategoryId);
					System.out.println(PhraseHelp);
					System.out.println(PhraseName);
					System.out.println(randomSelectionrow);

				} catch (Exception ex) {
					DialogHelper.showException(frmHangmanCategory, ex,
							"Something went wrong, Please try again!");
				}

			}
		});
	}

	/**
	 * 
	 * @return The Category that user selects from the CategoriesCombo.
	 * @author Alexandra Tzanidou
	 */
	public Object getCategory() {
		return SelectedCategory;
	}

	public void setCategory(Object Category) {
		this.SelectedCategory = Category;
	}

	/**
	 * method for handling a category's selection in the JComboBox
	 * 
	 * @param e
	 * @author Alexandra Tzanidou
	 */
	public void actionPerformed(ActionEvent e) {
		JComboBox<?> CategoriesCombo = (JComboBox<?>) e.getSource();
		SelectedCategory = CategoriesCombo.getSelectedItem();

	}

}
