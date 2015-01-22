package com.hangman.GUI.admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.service.PhrasesService;
import com.hangman.jdbc.to.Phrases;
import com.hangman.jdbc.to.PhrasesCriteria;

/**
 * PhraseTableModel extends AbstractTableModel, sets the model for the creation
 * of the JTable.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class PhraseTableModel extends AbstractTableModel {

	private PhrasesService phrasesService = new PhrasesService();
	private PhrasesCriteria phrasesCriteria = new PhrasesCriteria();
	private List<Phrases> phrases = phrasesService.findAll(phrasesCriteria);
	private Phrase phrase;
	private String[] columnNames = { "Id", "Category Id", "Name", "Help" };
	private Object[][] data = loadArray();

	public int getRowCount() {
		return phrases.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {

		return data[row][col];

	}

	/**
	 * Loads the 2 dimension array that populates the jtable.
	 * 
	 * @return
	 * @author Maria - Despoina Gkaintatzi
	 */
	private Object[][] loadArray() {

		Object[][] data = new Object[phrases.size()][columnNames.length];

		for (int row = 0; row < phrases.size(); row++) {
			for (int col = 0; col < columnNames.length; col++) {
				if (col == 0)
					data[row][col] = String.valueOf(phrases.get(row)
							.getPhraseID());
				else if (col == 1) {

					data[row][col] = new CategoryService().findCategoryName(
							row, phrases.get(row).getPhraseCategoryID());
				} else if (col == 2)
					data[row][col] = phrases.get(row).getPhraseName();
				else
					data[row][col] = phrases.get(row).getPhraseHelp();

			}
		}
		return data;
	}

}
