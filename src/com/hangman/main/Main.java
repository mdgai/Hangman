package com.hangman.main;

import java.awt.EventQueue;
import java.sql.SQLException;

import com.hangman.GUI.LoginGUI;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

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