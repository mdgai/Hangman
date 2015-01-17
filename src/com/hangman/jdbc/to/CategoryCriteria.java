package com.hangman.jdbc.to;

/**
 * 
 * CategoryCriteria object serves as an argument to database related methods.
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class CategoryCriteria {

	private String CategoryName;
	private Integer CategoryID;

	public String getCategoryName() {
		return CategoryName;
	}

	public void setUsername(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public Integer getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int id) {
		this.CategoryID = id;
	}

}
