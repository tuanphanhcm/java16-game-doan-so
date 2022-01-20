package cybersoft.javabackend.gamedoanso.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static final String url = "jdbc:mysql://localhost:3306/game";
	private static final String username = "root";
	private static final String password = "1234";
	
	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver cơ sở dữ liệu.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		
		return connection;
	}
}
