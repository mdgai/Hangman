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
import com.hangman.jdbc.to.Demo;

public class DemoDAO implements BaseDAO<Demo> {

	private Connection connection;
	private Statement statement;
	private PreparedStatement prepStatement;
	private ResultSet resultSet;

	public void add(Demo transferObject) {
		int rowsAffected = 0;
		try {
			String insertString = "INSERT INTO demo"
					+ "(id, first_name, last_name) VALUES" + "(?, ?, ?)";

			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(insertString);

			// Set parameters for the statement.
			prepStatement.setInt(1, transferObject.getId());
			prepStatement.setString(2, transferObject.getFirstName());
			prepStatement.setString(3, transferObject.getLastName());

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

	public void delete(int id) {
		int rowsAffected = 0;

		try {
			String queryString = "DELETE FROM demo WHERE id = ?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setInt(1, id);

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

	public void delete(Demo transferObject) {
		// TODO Auto-generated method stub
	}

	public void update(Demo transferObject) {
		int rowsAffected = 0;

		try {
			String queryString = "UPDATE demo SET "
					+ "first_name = ?, last_name = ?" + "WHERE id =?";

			// Establish a connection and a statement to the db
			connection = ConnectionFactory.getConnection();
			prepStatement = connection.prepareStatement(queryString);

			// Set parameters for the statement.
			prepStatement.setString(1, transferObject.getFirstName());
			prepStatement.setString(2, transferObject.getLastName());
			prepStatement.setInt(3, transferObject.getId());

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

	public List<Demo> findAll() {
		List<Demo> list = new ArrayList<Demo>();

		try {
			String queryString = "SELECT * FROM demo";

			// Establish a connection, create a statement and a result set
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queryString);

			// Retrieving results
			while (resultSet.next()) {
				Demo demoTO = new Demo();
				demoTO.setId(resultSet.getInt("id"));
				demoTO.setFirstName(resultSet.getString("first_name"));
				demoTO.setLastName(resultSet.getString("last_name"));

				// Add objects Farmer to List farmers
				list.add(demoTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());

		} finally {
			DbUtil.close(resultSet);
			DbUtil.close(statement);
			DbUtil.close(connection);
		}
		return list;
	}

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
