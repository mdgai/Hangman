package com.hangman.jdbc.to;

/**
 * Transfer Object User encapsulates business logic.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class User {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", isAdmin=" + isAdmin + "]";
	}

}
