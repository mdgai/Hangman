package com.hangman.jdbc.service;

import java.util.List;

import javax.swing.JComboBox;

import com.hangman.jdbc.dao.BaseDAO;
import com.hangman.jdbc.dao.CategoryDAO;
import com.hangman.jdbc.to.Category;
import com.hangman.jdbc.to.CategoryCriteria;

//import com.google.common.collect.Lists;

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

	/*
	 * public static DefaultComboBoxModel<List<?>> buildComboBoxModel() throws
	 * Exception { DefaultComboBoxModel<List<?>> comboBoxModel = new
	 * DefaultComboBoxModel<List<?>>(); try { CategoryService categoryservice =
	 * new CategoryService(); CategoryCriteria categorycriteria = new
	 * CategoryCriteria(); List<Category> categories = new
	 * ArrayList<Category>(); categories =
	 * categoryservice.findAll(categorycriteria);
	 * 
	 * for (List<Category> partition : Lists.partition(categories, 1)) {
	 * comboBoxModel.addElement(partition); } } catch (Exception e) {
	 * JOptionPane.showMessageDialog(null, "Sorry,Something went wrong!" + e); }
	 * return comboBoxModel; }
	 */

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

	/**
	 * Finds the apropriate Category after row selection
	 * 
	 * @param row
	 * @return the name of the Category
	 * @author Maria - Despoina Gkaintatzi
	 */
	public String findCategoryName(int row, int categoryId) {
		CategoryCriteria categoryCriteria = new CategoryCriteria();

		categoryCriteria.setCategoryID(categoryId);
		List<com.hangman.jdbc.to.Category> categoryList = findAll(categoryCriteria);

		return categoryList.get(0).getCategoryName();
	}

	/**
	 * Finds the apropriate Category id after selection in combo box.
	 * 
	 * @param row
	 * @return the id of the category
	 * @author Maria - Despoina Gkaintatzi
	 */
	public int findCategoryId(JComboBox<String> combo) {

		CategoryCriteria categoryCriteria = new CategoryCriteria();

		categoryCriteria
				.setCategoryName(String.valueOf(combo.getSelectedItem()));
		List<com.hangman.jdbc.to.Category> categoryList = findAll(categoryCriteria);

		return categoryList.get(0).getCategoryID();
	}
}
