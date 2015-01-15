package com.hangman.jdbc.service;

import java.util.List;

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

}
