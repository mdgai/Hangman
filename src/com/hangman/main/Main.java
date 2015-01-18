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

		CategoryService Categoryservice = new CategoryService();
		CategoryCriteria Categorycriteria = new CategoryCriteria();
		Category Category = new Category();
		List<Category> categories = new ArrayList<Category>();
		categories = Categoryservice.findAll(Categorycriteria);
		for (Category currentCategory : categories)
			;

		System.out.println(categories.toString());

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