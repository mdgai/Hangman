package com.hangman.GUI.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.to.CategoryCriteria;

/**
 * This class provides editing of table Phrases through a GUI
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class Phrase extends JPanel {

	private JPanel editPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JLabel lblId;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtHelp;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancel;
	private PhraseTableModel phraseTableModel;
	private JTable table;
	private JLabel lblCategoryId;
	private JLabel lblName;
	private JLabel lblHelp;
	private JComboBox<String> categoryIdCombo;

	/**
	 * Create the panel.
	 */
	public Phrase() {
		initialize();
		createEvents();
	}

	/**
	 * Creates all components of the panel.
	 * 
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void initialize() {

		// Set Jpanel
		setName("Phrase");
		setBounds(5, 20, 475, 400);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[grow]", "[grow][200px,grow][100px,grow]"));

		// Create panels
		editPanel = new JPanel();
		add(editPanel, "cell 0 1,grow");
		editPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));

		buttonPanel = new JPanel();
		add(buttonPanel, "cell 0 2,grow");
		buttonPanel.setLayout(new MigLayout("", "[][][][grow][]", "[]"));

		// Create labels
		lblId = new JLabel("Id:");
		editPanel.add(lblId, "cell 0 0,alignx trailing");

		lblCategoryId = new JLabel("Category:");
		editPanel.add(lblCategoryId, "cell 0 1,alignx trailing");

		// Create Combo box
		categoryIdCombo = new JComboBox();
		loadCategoryCombo(categoryIdCombo);
		editPanel.add(categoryIdCombo, "cell 1 1,growx");

		lblName = new JLabel("Name:");
		editPanel.add(lblName, "cell 0 2,alignx trailing");

		lblHelp = new JLabel("Help:");
		editPanel.add(lblHelp, "cell 0 3,alignx trailing");

		// Create textFields
		txtId = new JTextField();
		txtId.setText("");
		editPanel.add(txtId, "cell 1 0,growx");
		txtId.setColumns(10);
		txtId.setEnabled(false); // Disable textField id

		txtName = new JTextField();
		txtName.setText("");
		editPanel.add(txtName, "cell 1 2,growx");
		txtName.setColumns(10);

		txtHelp = new JTextField();
		txtHelp.setText("");
		editPanel.add(txtHelp, "cell 1 3,growx");
		txtHelp.setColumns(10);

		// Create buttons
		btnInsert = new JButton("Insert");
		btnInsert.setIcon(new ImageIcon(Category.class
				.getResource("/com/hangman/data/add.png")));
		buttonPanel.add(btnInsert, "cell 0 0,growx");

		btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(Category.class
				.getResource("/com/hangman/data/update.png")));
		buttonPanel.add(btnUpdate, "cell 1 0,growx");

		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(Category.class
				.getResource("/com/hangman/data/delete.png")));
		buttonPanel.add(btnDelete, "cell 2 0,growx");

		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Category.class
				.getResource("/com/hangman/data/cancel.png")));
		buttonPanel.add(btnCancel, "cell 4 0,growx");

		// Create table
		phraseTableModel = new PhraseTableModel();
		table = new JTable(phraseTableModel);
		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);
		add(scrollPane, "cell 0 0,grow");

		// Set frame visible
		setVisible(true);
	}

	/**
	 * Handles all the events of the form.
	 * 
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void createEvents() {
		// Creates a button listener
		ButtonListener buttonListener = new ButtonListener(btnUpdate,
				btnDelete, btnInsert, btnCancel, txtId, categoryIdCombo,
				txtName, txtHelp, table, this);

		// Add listener for button events
		btnInsert.addActionListener(buttonListener);
		btnCancel.addActionListener(buttonListener);
		btnDelete.addActionListener(buttonListener);
		btnUpdate.addActionListener(buttonListener);

		// Add listener for mouse events
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				// Get selected row
				int row = table.getSelectedRow();

				// Fill textFields and combo with the values of the selected row
				txtId.setText(String.valueOf(table.getValueAt(row, 0)));
				categoryIdCombo.setSelectedItem(table.getValueAt(row, 1));
				txtName.setText(String.valueOf(table.getValueAt(row, 2)));
				txtHelp.setText(String.valueOf(table.getValueAt(row, 3)));
			}

		});

	}

	/**
	 * Loads the categories of table Categories in the specified combo box.
	 * 
	 * @param combo
	 * @author Maria - Despoina Gkaintatzi
	 */
	private void loadCategoryCombo(JComboBox<String> combo) {

		List<com.hangman.jdbc.to.Category> categoryList = new CategoryService()
				.findAll(new CategoryCriteria());

		for (com.hangman.jdbc.to.Category currentCategory : categoryList) {
			combo.addItem(currentCategory.getCategoryName());
		}
	}
}
