package com.hangman.jdbc.to;

/**
 * Transfer Object Category
 * 
 * @author Alexandra Tzanidou
 * 
 */
public class Category {

	@Override
	public String toString() {
		return CategoryID + "." + CategoryName;
	}

	private String CategoryName;
	private int CategoryID;

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryId(int CategoryID) {
		this.CategoryID = CategoryID;
	}

}
