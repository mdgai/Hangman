package com.hangman.GUI.admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.to.Category;
import com.hangman.jdbc.to.CategoryCriteria;

public class CategoryTableModel extends AbstractTableModel {

	private CategoryService categoryService = new CategoryService();
	private CategoryCriteria categoryCriteria = new CategoryCriteria();
	private List<Category> category = categoryService.findAll(categoryCriteria);
	private String[] columnNames = { "Id", "Category" };
	private Object[][] data = loadArray();

	public int getRowCount() {
		return category.size();
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

		Object[][] data = new Object[category.size()][columnNames.length];

		for (int row = 0; row < category.size(); row++) {
			for (int col = 0; col < columnNames.length; col++) {
				if (col == 0)
					data[row][col] = String.valueOf(category.get(row)
							.getCategoryID());
				else
					data[row][col] = category.get(row).getCategoryName();

			}
		}
		return data;
	}

}