package com.hangman.jdbc.to;

/**
 * UserCriteria object serves as an argument to database related methods.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class UserCriteria {

	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Integer isAdmin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAdmin() {
		return isAdmin;
	}

	public void setAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

}
