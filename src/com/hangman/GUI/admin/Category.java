package com.hangman.GUI.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import net.miginfocom.swing.MigLayout;

/**
 * This class provides editing of table Categories through a GUI.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class Category extends JPanel {

	private JPanel editPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JTable table;
	private CategoryTableModel categoryTableModel;
	private DefaultTableCellRenderer centeredRenderer;
	private JLabel lblId;
	private JLabel lblCategory;
	private JTextField txtId;
	private JTextField txtCategory;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public Category() {
		initialize();
		createEvents();
	}

	// Creates all components of the panel
	private void initialize() {
		// Set the panel
		setName("Category");
		setBounds(5, 20, 475, 400);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[grow,fill]",
				"[grow][200px,grow][100px,grow]"));

		// Create panels
		editPanel = new JPanel();
		add(editPanel, "cell 0 1,grow");
		editPanel.setLayout(new MigLayout("", "[][grow]", "[][]"));

		buttonPanel = new JPanel();
		add(buttonPanel, "cell 0 2,grow");
		buttonPanel.setLayout(new MigLayout("", "[][][][grow][]", "[]"));

		// Create labels
		lblId = new JLabel("Id:");
		editPanel.add(lblId, "cell 0 0,alignx trailing");

		lblCategory = new JLabel("Category: ");
		editPanel.add(lblCategory, "cell 0 1,alignx trailing");

		// Create textFields
		txtId = new JTextField();
		txtId.setText("");
		editPanel.add(txtId, "cell 1 0,growx");
		txtId.setColumns(10);
		txtId.setEnabled(false); // Disable textField id

		txtCategory = new JTextField();
		txtCategory.setText("");
		editPanel.add(txtCategory, "cell 1 1,growx");
		txtCategory.setColumns(10);

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
		categoryTableModel = new CategoryTableModel();
		table = new JTable(categoryTableModel);
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
				btnDelete, btnInsert, btnCancel, txtId, txtCategory, table,
				this);

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

				// Fill textFields with the values of the selected row
				txtId.setText(String.valueOf(table.getValueAt(row, 0)));
				txtCategory.setText(String.valueOf(table.getValueAt(row, 1)));
			}
		});

	}

}
