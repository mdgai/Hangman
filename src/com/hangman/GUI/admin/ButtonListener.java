package com.hangman.GUI.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.service.PhrasesService;
import com.hangman.jdbc.to.Phrases;

/**
 * Button listener is an implementation of ActionListener for buttons of classes
 * Category and Phrase.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class ButtonListener implements ActionListener {

	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnCancel;
	private JTextField txtId;
	private JTextField txtCategory;
	private JTextField txtName;
	private JTextField txtHelp;
	private JComboBox<String> categoryIdCombo;
	private JTable table;
	private JPanel panel;

	public ButtonListener(JButton btnUpdate, JButton btnDelete,
			JButton btnInsert, JButton btnCancel, JTextField txtId,
			JTextField txtCategory, JTable table, JPanel panel) {
		super();
		this.btnUpdate = btnUpdate;
		this.btnDelete = btnDelete;
		this.btnInsert = btnInsert;
		this.btnCancel = btnCancel;
		this.txtId = txtId;
		this.txtCategory = txtCategory;
		this.table = table;
		this.panel = panel;
	}

	public ButtonListener(JButton btnUpdate, JButton btnDelete,
			JButton btnInsert, JButton btnCancel, JTextField txtId,
			JComboBox<String> categoryIdCombo, JTextField txtName,
			JTextField txtHelp, JTable table, JPanel panel) {
		super();
		this.btnUpdate = btnUpdate;
		this.btnDelete = btnDelete;
		this.btnInsert = btnInsert;
		this.btnCancel = btnCancel;
		this.txtId = txtId;
		this.categoryIdCombo = categoryIdCombo;
		this.txtName = txtName;
		this.txtHelp = txtHelp;
		this.table = table;
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		if (panel.getName() == "Category") {
			categoryButtonEvents(e);
		} else if (panel.getName() == "Phrase") {
			phraseButtonEvents(e);
		}
	}

	private void categoryButtonEvents(ActionEvent e) {
		CategoryService categoryService = new CategoryService();

		if (e.getSource() == btnInsert) {

			com.hangman.jdbc.to.Category insertCategory = new com.hangman.jdbc.to.Category();
			// insertCategory.setCategoryId(Integer.parseInt(txtId.getText()));
			insertCategory.setCategoryName(txtCategory.getText());

			categoryService.add(insertCategory);

		}
		if (e.getSource() == btnDelete) {

			int row = table.getSelectedRow();

			com.hangman.jdbc.to.Category deleteCategory = new com.hangman.jdbc.to.Category();
			deleteCategory.setCategoryId(Integer.parseInt(String.valueOf(table
					.getValueAt(row, 0))));
			deleteCategory.setCategoryName(String.valueOf(table.getValueAt(row,
					1)));

			categoryService.delete(deleteCategory);

		}
		if (e.getSource() == btnUpdate) {

			com.hangman.jdbc.to.Category updateCategory = new com.hangman.jdbc.to.Category();
			updateCategory.setCategoryId(Integer.parseInt(txtId.getText()));
			updateCategory.setCategoryName(txtCategory.getText());

			categoryService.update(updateCategory);
		}
		if (e.getSource() == btnCancel) {

			panel.setVisible(false);
		}

		txtId.setText("");
		txtCategory.setText("");

		table.setModel(new CategoryTableModel());
	}

	private void phraseButtonEvents(ActionEvent e) {

		PhrasesService phrasesService = new PhrasesService();

		if (e.getSource() == btnInsert) {

			Phrases insertPhrase = new Phrases();

			insertPhrase.setPhraseCategoryID(new CategoryService()
					.findCategoryId(categoryIdCombo));
			insertPhrase.setPhraseName(txtName.getText());
			insertPhrase.setPhraseHelp(txtHelp.getText());

			phrasesService.add(insertPhrase);

		}
		if (e.getSource() == btnDelete) {

			int row = table.getSelectedRow();

			Phrases deletePhrase = new Phrases();

			deletePhrase.setPhraseID(Integer.parseInt(String.valueOf(table
					.getValueAt(row, 0))));
			deletePhrase.setPhraseCategoryID(new CategoryService()
					.findCategoryId(categoryIdCombo));
			deletePhrase
					.setPhraseName(String.valueOf(table.getValueAt(row, 2)));
			deletePhrase
					.setPhraseHelp(String.valueOf(table.getValueAt(row, 3)));

			phrasesService.delete(deletePhrase);

		}
		if (e.getSource() == btnUpdate) {

			Phrases updatePhrase = new Phrases();
			updatePhrase.setPhraseID(Integer.parseInt(txtId.getText()));
			updatePhrase.setPhraseCategoryID(new CategoryService()
					.findCategoryId(categoryIdCombo));
			updatePhrase.setPhraseName(txtName.getText());
			updatePhrase.setPhraseHelp(txtHelp.getText());

			phrasesService.update(updatePhrase);
		}
		if (e.getSource() == btnCancel) {

			panel.setVisible(false);
		}

		txtId.setText("");
		categoryIdCombo.setSelectedIndex(0);
		txtName.setText("");
		txtHelp.setText("");

		table.setModel(new PhraseTableModel());
	}

}
