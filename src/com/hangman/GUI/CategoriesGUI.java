package com.hangman.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hangman.jdbc.service.CategoryService;

/**
 * Initialize the contents of the frame.
 * 
 * @author Alexandra Tzanidou
 */

public class CategoriesGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
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
		final JComboBox CategoriesCombo = new JComboBox();
		CategoriesCombo.setModel(CategoryService.buildComboBoxModel());
		CategoriesCombo.setVisible(true);
		CategoriesCombo.setBounds(140, 155, 200, 40);
		CategoriesCombo.setSelectedIndex(0);
		CategoriesCombo.addActionListener(this);
		CategoriesCombo.setBackground(getForeground());
		panel.add(CategoriesCombo);

		/*
		 * panel.add(new JList(), BorderLayout.CENTER); JList<CategoryService>
		 * CategoryList = new JList<CategoryService>();
		 * CategoryList.setVisible(true);
		 * CategoryList.add(CategoryService.this.getListWithCategories(), null);
		 * CategoryList.getSelectionModel();
		 * CategoryList.setBounds(getMaximizedBounds());
		 * CategoryService.fillListWithCategories(); // creates JComboBox //
		 * JComboBox<Object> CategiesCombo = new JComboBox<Object>().; //
		 * CategoriesCombo.addItem(CategoriesCombo); //
		 * CategoriesCombo.setBounds(140, 155, 200, 40); //
		 * CategoriesCombo.setVisible(true); // panel;
		 */

		// Creates the selection button
		JButton btnDone = new JButton("Done!");
		btnDone.setBounds(180, 230, 89, 23);
		btnDone.setToolTipText("Please Select a Category from the list, and then Click me!");
		panel.add(btnDone);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object contents = CategoriesCombo.getSelectedIndex();
				System.out.println(contents);
			}
		});
	}

	/**
	 * 
	 * @return The Category that user selects from the CategoriesCombo.
	 * @author Alexandra Tzanidou
	 */
	public Object getCategory() {
		return "[" + this.SelectedCategory.toString() + "]";
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
		JComboBox CategoriesCombo = (JComboBox) e.getSource();
		String SelectedCategory = (String) CategoriesCombo.getSelectedItem();

	}

}
