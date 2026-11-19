package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Opens JDBC connections to the employment_db MySQL database. */
public class DBConnection {

	private static final String URL =
			"jdbc:mysql://localhost:3306/employment_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Toronto";
	private static final String USER = "root";
	private static final String PASSWORD = "root1234"; 

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
