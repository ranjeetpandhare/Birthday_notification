package application.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/birthday_notification";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection connection = null;

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return connection;

	}
}
