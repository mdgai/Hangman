package com.hangman.jdbc.service;

import java.util.List;

import com.hangman.jdbc.dao.BaseDAO;
import com.hangman.jdbc.dao.UserDAO;
import com.hangman.jdbc.to.User;
import com.hangman.jdbc.to.UserCriteria;

/**
 * Class that provides services to table user, such as INSERT, DELETE, UPDATE
 * etc.
 * 
 * @author Maria - Despoina Gkaintatzi
 * 
 */
public class UserService {

	private BaseDAO<User> userDAO = new UserDAO();

	public void add(User user) {
		userDAO.add(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public List<User> findAll(UserCriteria user) {
		return userDAO.findAll(user);

	}

	/**
	 * Method for checking if a user is authenticated.
	 * 
	 * @param username
	 * @param password
	 * @return true if a user is authenticated
	 * @author Maria - Despoina Gkaintatzi
	 */
	public Boolean isAuthenticatedUser(String username, String password) {

		// Username and Password must have a value.
		if (username != null && password != null) {
			UserCriteria user = new UserCriteria();
			user.setUsername(username);
			user.setPassword(password);

			if (!findAll(user).isEmpty())
				return true;
		}

		return false;

	}

	/**
	 * Method for checking if a user is administrator
	 * 
	 * @param username
	 * @param password
	 * @return true if user is administrator
	 * @author Maria - Despoina Gkaintatzi
	 */
	public Boolean isAdmin(String username, String password) {

		if (isAuthenticatedUser(username, password)) {
			UserCriteria user = new UserCriteria();
			user.setUsername(username);
			user.setPassword(password);
			user.setAdmin(1);

			if (!findAll(user).isEmpty())
				return true;
		}

		return false;
	}
}
