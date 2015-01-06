package com.hangman.main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import com.hangman.GUI.LoginGUI;
import com.hangman.jdbc.dao.DemoDAO;
import com.hangman.jdbc.to.Demo;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
	SQLException {
		System.out.println("Hello from main!!!");
		/*
		 * DemoDAO demoDAO = new DemoDAO(); DemoTO insertObject = new DemoTO();
		 * 
		 * insertObject.setFirstName("Aleksandra");
		 * insertObject.setLastName("Tzanidou");
		 * 
		 * demoDAO.add(insertObject);
		 * 
		 * ArrayList<DemoTO> demoObject = demoDAO.findAll();
		 * 
		 * for (DemoTO demoTO : demoObject) {
		 * System.out.println(demoTO.toString()); }
		 */

		/*DemoDAO demoDAO = new DemoDAO();
		Demo insertObject = new Demo();

		insertObject.setFirstName("First name");
		insertObject.setLastName("Last name");

		demoDAO.add(insertObject);

		List<Demo> demoList = demoDAO.findAll();

		for (Demo demoTO : demoList) {
			System.out.println(demoTO.toString());
		}*/

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