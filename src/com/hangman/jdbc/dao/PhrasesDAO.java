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
import com.hangman.jdbc.to.Phrases;

/**
 * 
 * PhrasesDAO class used for related operations with the table Phrases in
 * database hangman.
 * 
 * @author Tzanidou Alexandra
 * 
 */
public class PhrasesDAO implements BaseDAO<Phrases> {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;

	/**
	 * Inserts a Phrases object into table Phrases .
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void add(Phrases transferObject) {
		int rowsAffected = 0;
		try {
			String insertString = "INSERT INTO Phrases"
					+ "(PhraseID, PhraseCategoryID, PhraseName, PhraseHelp) VALUES"
					+ "(?, ?, ?, ?)";

			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(insertString);

			// Set parameters for the statement.

			prepStatement.setInt(1, transferObject.getPhraseID());
			prepStatement.setInt(2, transferObject.getPhraseCategoryID());
			prepStatement.setString(3, transferObject.getPhraseName());
			prepStatement.setString(4, transferObject.getPhraseHelp());

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
	 ** Deletes a Phrases object from table Phrases.
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void delete(Phrases transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "DELETE FROM Phrases WHERE PhraseID = ?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setInt(1, transferObject.getPhraseID());

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
	 * Updates a Phrases object in table Phrases.
	 * 
	 * @param transferObject
	 * @author Tzanidou Alexandra
	 */
	public void update(Phrases transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "UPDATE Phrases SET "
					+ "PhraseName = ?, PhraseCategoryID = ? PhraseHelp = ? "
					+ "WHERE PhraseID =?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setString(1, transferObject.getPhraseName());
			prepStatement.setInt(2, transferObject.getPhraseCategoryID());
			prepStatement.setString(3, transferObject.getPhraseHelp());
			prepStatement.setInt(4, transferObject.getPhraseID());

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
	 * Returns a list of records of table Phrases depending on PhrasesCriteria
	 * object argument.
	 * 
	 * @param criteriaObject
	 *            is used in order to fetch a subset of the total records of
	 *            table Phrases (it's used like a WHERE clause in SELECT
	 *            statement).
	 * @return a list of Phrases
	 * @author Alexandra Tzanidou
	 */
	public <PhrasesCriteria> List<Phrases> findAll(
			PhrasesCriteria PhrasesCriteria) {
		List<Phrases> list = new ArrayList<Phrases>();

		try {
			String queryString = "SELECT * FROM Phrases WHERE PhraseID = COALESCE(?, PhraseID) "
					+ "AND PhraseName = COALESCE(?, PhraseName) "
					+ "AND PhraseCategoryID = COALESCE(?, PhraseCategoryID) "
					+ "AND PhraseHelp = COALESCE(?, PhraseHelp) ";

			// Establish a connection, create a prepare statement and a result
			// set
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			prepStatement.setObject(1,
					((com.hangman.jdbc.to.PhrasesCriteria) PhrasesCriteria)
							.getPhraseID());
			prepStatement.setString(2,
					((com.hangman.jdbc.to.PhrasesCriteria) PhrasesCriteria)
							.getPhraseName());
			prepStatement.setInt(3,
					((com.hangman.jdbc.to.PhrasesCriteria) PhrasesCriteria)
							.getPhraseCategoryID());
			prepStatement.setString(4,
					((com.hangman.jdbc.to.PhrasesCriteria) PhrasesCriteria)
							.getPhraseHelp());

			resultSet = prepStatement.executeQuery();

			// Retrieving results
			while (resultSet.next()) {
				Phrases PhrasesTO = new Phrases();
				PhrasesTO.setPhraseID(resultSet.getInt("PhraseID"));
				PhrasesTO.setPhraseCategoryID(resultSet
						.getInt("PhraseCategoryID"));
				PhrasesTO.setPhraseName(resultSet.getString("PhraseName"));
				PhrasesTO.setPhraseHelp(resultSet.getString("PhraseHelp"));

				// Add objects Phrases to List Phrases
				list.add(PhrasesTO);
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
