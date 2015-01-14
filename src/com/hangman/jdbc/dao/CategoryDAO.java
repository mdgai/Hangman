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
import com.hangman.jdbc.to.Category;

/**
 * CategoryDAO class used for releted operations with the table user in database
 * hangman.
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class CategoryDAO implements BaseDAO<Category> {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;

	/**
	 * Inserts a Category object into table Category .
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void add(Category transferObject) {
		int rowsAffected = 0;
		try {
			String insertString = "INSERT INTO Categories"
					+ "(CategoryID, CategoryName) VALUES" + "(?, ?)";

			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(insertString);

			// Set parameters for the statement.

			prepStatement.setInt(1, transferObject.getCategoryID());
			prepStatement.setString(2, transferObject.getCategoryName());

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
	 * Deletes a Category object from table Categories.
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void delete(Category transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "DELETE FROM Categories WHERE CategoryID = ?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setInt(1, transferObject.getCategoryID());

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
	 * Updates a Category object in table Categories.
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void update(Category transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "UPDATE Categories SET " + "CategoryName = ? "
					+ "WHERE CategoryID =?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setString(1, transferObject.getCategoryName());
			prepStatement.setInt(2, transferObject.getCategoryID());

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
	 * Returns a list of records of table Categories depending on
	 * CategoryCriteria object argument.
	 * 
	 * @param criteriaObject
	 *            is used in order to fetch a subset of the total records of
	 *            table Phrases (it's used like a WHERE clause in SELECT
	 *            statement).
	 * @return a list of Categories
	 * @author Alexandra Tzanidou
	 */
	public <CategoryCriteria> List<Category> findAll(
			CategoryCriteria CategoryCriteria) {
		List<Category> list = new ArrayList<Category>();

		try {
			String queryString = "SELECT * FROM Categories WHERE CategoryID = COALESCE(?, CategoryID) "
					+ "AND CategoryName = COALESCE(?, CategoryName) ";

			// Establish a connection, create a prepare statement and a result
			// set
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			prepStatement.setObject(1,
					((com.hangman.jdbc.to.CategoryCriteria) CategoryCriteria)
							.getCategoryID());
			prepStatement.setString(2,
					((com.hangman.jdbc.to.CategoryCriteria) CategoryCriteria)
							.getCategoryName());

			resultSet = prepStatement.executeQuery();

			// Retrieving results
			while (resultSet.next()) {
				Category CategoryTO = new Category();
				CategoryTO.setCategoryId(resultSet.getInt("CategoryID"));
				CategoryTO.setCategoryName(resultSet.getString("CategoryName"));

				// Add objects Category to List Category
				list.add(CategoryTO);
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
	 * @author Tzanidou Alexandra
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
