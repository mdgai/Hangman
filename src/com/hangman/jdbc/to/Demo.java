package com.hangman.jdbc.to;

/**
 * Transfer Object pattern encapsulates business data.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class Demo {
	private int id;
	private String firstName;
	private String lastName;

	// Getters and Setters methods.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Demo [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
