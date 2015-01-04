package com.hangman.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A singleton class {@link ConnectionFactory} that returns database Connection
 * objects.
 * 
 * @author Maria - Despoina Gkaintatzi
 *
 */
public class ConnectionFactory {
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://db4free.net:3306/hangman";
	public static final String USER = "hangmanuser";
	public static final String PASSWORD = "hangman";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// private constructor
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// private method createConnection
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Static method that returns a {@link Connection} object.
	 * 
	 * @return A connection object.
	 * @author Maria - Despoina Gkaintatzi
	 */
	public static Connection getConnection() {

		return instance.createConnection();
	}

}
