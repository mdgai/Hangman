package com.hangman.users;

import com.hangman.jdbc.dao.DemoDAO;
import com.hangman.jdbc.to.Demo;
import com.hangman.GUI.LoginGUI;

public class Player extends User {
	
	private int Score;
	
	public Player(String firstname,String lastname, String username, String password, int hours, int score) {
		super(username, password, firstname, lastname, hours);
		Score = score;
	}
	
	public String printScore() {
		String ScoreText =  "User recognised: " + Username + "Total personal Score=" + Score ;
		return ScoreText;
	}

	
}
