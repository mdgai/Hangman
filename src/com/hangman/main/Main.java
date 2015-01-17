package com.hangman.main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hangman.GUI.LoginGUI;
import com.hangman.jdbc.service.CategoryService;
import com.hangman.jdbc.to.Category;
import com.hangman.jdbc.to.CategoryCriteria;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		CategoryService categoryservice = new CategoryService();
		CategoryCriteria categorycriteria = new CategoryCriteria();
		Category category = new Category();
		List<Category> categories = new ArrayList<Category>();
		List<String> query1 = new ArrayList<String>();
		categories = categoryservice.findAll(categorycriteria);
		for (Category currentCategory : categories)
			;
		query1.add(categories.toString());
		System.out.println(query1);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}