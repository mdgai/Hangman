package com.hangman.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hangman.jdbc.db.ConnectionFactory;
import com.hangman.jdbc.db.DbUtil;
import com.hangman.jdbc.to.User;

/**
 * UserDAO class used for releted operations with the table user in database
 * hangman.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class UserDAO implements BaseDAO<User> {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;

	/**
	 * Inserts a user object to table user.
	 * 
	 * @param transferObject
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void add(User transferObject) {
		int rowsAffected = 0;
		try {
			String insertString = "INSERT INTO user"
					+ "(username, password, first_name, last_name, is_admin) VALUES"
					+ "(?, ?, ?, ?, ?)";

			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(insertString);

			// Set parameters for the statement.
			// prepStatement.setInt(1, transferObject.getId());
			prepStatement.setString(1, transferObject.getUsername());
			prepStatement.setString(2, transferObject.getPassword());
			prepStatement.setString(3, transferObject.getFirstName());
			prepStatement.setString(4, transferObject.getLastName());
			prepStatement.setBoolean(5, transferObject.isAdmin());

			// execute the statement
			rowsAffected = prepStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			rowAffect(rowsAffected);
			DbUtil.close(prepStatement);
			DbUtil.close(connection);
		}
	}

	/**
	 * Deletes a user object in table user.
	 * 
	 * @param transferObject
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void delete(User transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "DELETE FROM user WHERE id = ?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setInt(1, transferObject.getId());

			// execute the statement
			rowsAffected = prepStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		} finally {
			rowAffect(rowsAffected);
			DbUtil.close(prepStatement);
			DbUtil.close(connection);
		}
	}

	/**
	 * Updates a user object in table user.
	 * 
	 * @param transferObject
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void update(User transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "UPDATE user SET "
					+ "username = ?, password = ?, first_name = ?, last_name = ?, is_admin = ? "
					+ "WHERE id =?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setString(1, transferObject.getUsername());
			prepStatement.setString(2, transferObject.getPassword());
			prepStatement.setString(3, transferObject.getFirstName());
			prepStatement.setString(4, transferObject.getLastName());
			prepStatement.setBoolean(5, transferObject.isAdmin());
			prepStatement.setInt(6, transferObject.getId());

			// execute the statement
			rowsAffected = prepStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		} finally {
			rowAffect(rowsAffected);
			DbUtil.close(prepStatement);
			DbUtil.close(connection);
		}

	}

	/**
	 * * Returns a list of records of table user depending on UserCriteria
	 * object argument.
	 * 
	 * @param criteriaObject
	 *            is used in order to fetch a subset of the total records of
	 *            table user (it's used like a WHERE clause in SELECT
	 *            statement).
	 * @return a list of users
	 * @author Maria - Despoina Gkaintatzi
	 */
	public <UserCriteria> List<User> findAll(UserCriteria userCriteria) {
		List<User> list = new ArrayList<User>();

		try {
			String queryString = "SELECT * FROM user WHERE id = COALESCE(?, id) "
					+ "AND username = COALESCE(?, username) "
					+ "AND password = COALESCE(?, password) "
					+ "AND first_name = COALESCE(?, first_name) "
					+ "AND last_name = COALESCE(?, last_name) "
					+ "AND is_admin = COALESCE(?, is_admin)";

			// Establish a connection, create a prepare statement and a result
			// set
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			prepStatement.setObject(1,
					((com.hangman.jdbc.to.UserCriteria) userCriteria).getId());
			prepStatement.setString(2,
					((com.hangman.jdbc.to.UserCriteria) userCriteria)
							.getUsername());
			prepStatement.setString(3,
					((com.hangman.jdbc.to.UserCriteria) userCriteria)
							.getPassword());
			prepStatement.setString(4,
					((com.hangman.jdbc.to.UserCriteria) userCriteria)
							.getFirstName());
			prepStatement.setString(5,
					((com.hangman.jdbc.to.UserCriteria) userCriteria)
							.getLastName());
			prepStatement.setObject(6,
					((com.hangman.jdbc.to.UserCriteria) userCriteria)
							.getAdmin());

			resultSet = prepStatement.executeQuery();

			// Retrieving results
			while (resultSet.next()) {
				User userTO = new User();
				userTO.setId(resultSet.getInt("id"));
				userTO.setUsername(resultSet.getString("username"));
				userTO.setPassword(resultSet.getString("password"));
				userTO.setFirstName(resultSet.getString("first_name"));
				userTO.setLastName(resultSet.getString("last_name"));
				userTO.setAdmin(resultSet.getBoolean("is_admin"));

				// Add objects User to List users
				list.add(userTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		} finally {
			DbUtil.close(resultSet);
			DbUtil.close(prepStatement);
			DbUtil.close(connection);
		}
		return list;
	}

	/**
	 * Prints a message of how many records have been changed after a certain
	 * request.
	 * 
	 * @param rows
	 * @author Maria - Despoina Gkaintatzi
	 */
	public void rowAffect(int rows) {
		if (rows == 0) {
			System.out
					.println("There is no record to satisfy the given specifications. "
							+ "Your request has not been completed");
		} else if (rows == 1) {
			System.out.println("One record has been modified. "
					+ "Your request has been successfully completed");
		} else {
			System.out.println(rows + " records have been modified. "
					+ "Your request has been successfully completed");
		}
	}

}
