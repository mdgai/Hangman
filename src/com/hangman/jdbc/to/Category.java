package com.hangman.jdbc.to;

/**
 * Transfer Object Category
 * 
 * @author Alexandra Tzanidou
 * 
 */
public class Category {

	private String CategoryName;
	private int CategoryId;

	public String getCategoryName() {
		return CategoryName;
	}

	public void setUsername(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int id) {
		this.CategoryId = id;
	}

}
