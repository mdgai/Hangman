package com.hangman.users;

import com.hangman.jdbc.dao.DemoDAO;
import com.hangman.jdbc.to.Demo;
import com.hangman.GUI.LoginGUI;

public class Admin extends User{
	
	

	public Admin(String firstname,String lastname, String username, String password, int hours, int score) {
		super(username, password, firstname, lastname, hours);
		
	}

}
