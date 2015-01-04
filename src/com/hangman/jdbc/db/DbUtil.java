package com.hangman.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Helper class {@link DbUtil} that provides methods for closing database
 * resources, such as {@link Connection}, {@link Statement},
 * {@link PreparedStatement} and {@link ResultSet}.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class DbUtil {

	/**
	 * Static method for closing database {@link Connection} objects.
	 * 
	 * @param connection
	 *            To be closed.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Static method for closing database {@link Statement} objects.
	 * 
	 * @param statement
	 *            To be closed.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Static method for closing database {@link PreparedStatement} objects.
	 * 
	 * @param prepStatement
	 *            To be closed.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void close(PreparedStatement prepStatement) {
		if (prepStatement != null) {
			try {
				prepStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Static method for closing database {@link ResultSet} objects.
	 * 
	 * @param resultSet
	 *            To be closed.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
