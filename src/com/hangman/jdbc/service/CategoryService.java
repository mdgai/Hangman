package com.hangman.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.google.common.collect.Lists;
import com.hangman.jdbc.dao.BaseDAO;
import com.hangman.jdbc.dao.CategoryDAO;
import com.hangman.jdbc.to.Category;
import com.hangman.jdbc.to.CategoryCriteria;

/**
 * Class that provides services to table Category, such as INSERT, DELETE,
 * UPDATE etc.
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class CategoryService {

	private BaseDAO<Category> CategoryDAO = new CategoryDAO();

	public void add(Category Category) {
		CategoryDAO.add(Category);
	}

	public void delete(Category Category) {
		CategoryDAO.delete(Category);
	}

	public void update(Category Category) {
		CategoryDAO.update(Category);
	}

	public List<Category> findAll(CategoryCriteria Category) {
		return CategoryDAO.findAll(Category);

	}

	public static DefaultComboBoxModel<List<?>> buildComboBoxModel()
			throws Exception {
		DefaultComboBoxModel<List<?>> comboBoxModel = new DefaultComboBoxModel<List<?>>();
		try {
			CategoryService categoryservice = new CategoryService();
			CategoryCriteria categorycriteria = new CategoryCriteria();
			List<Category> categories = new ArrayList<Category>();
			categories = categoryservice.findAll(categorycriteria);

			for (List<Category> partition : Lists.partition(categories, 1)) {
				comboBoxModel.addElement(partition);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sorry,Something went wrong!"
					+ e);
		}
		return comboBoxModel;
	}

	public String CategorySelection(String isSelected) {

		CategoryCriteria Category = new CategoryCriteria();
		Category.setCategoryName(isSelected);
		return isSelected;
	}

	public Integer CategoryId(int SelectionsId) {

		CategoryCriteria Category = new CategoryCriteria();
		Category.setCategoryID(SelectionsId);
		return SelectionsId;
	}
}
