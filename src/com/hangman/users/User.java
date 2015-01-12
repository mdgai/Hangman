package com.hangman.users;

import com.hangman.jdbc.dao.DemoDAO;
import com.hangman.jdbc.to.Demo;
import com.hangman.GUI.LoginGUI;

public class User {
	private String FirstName;
	private String LastName;
	protected String Username;
	protected String Password;
	private int PlayingHours;
	public User(String firstname,String lastname,String username, String password, int hours) {
		FirstName = firstname;
		LastName = lastname;
		Username = username;
		Password= password;
		PlayingHours = hours; //To anagnwristiko PlayingHours dilwnei tis wres pou opoiosdipote xristis asxolithike
							// me to programma, asxetws tou an epaixe (paiktis), i an apla doulepse se auto "admin"
	}
	
	public String UserAccess() {
		String accessMessage = "User recognised: " + Username ;
		return accessMessage;
	}
	
	public String UserInfo(){
		String userInfo = "First Name:" + FirstName +"Last Name:"+ LastName + "Playing Hours"+PlayingHours;
		return userInfo;
		
	}
	

}
