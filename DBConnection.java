package finalproject;

import java.sql.*;
public class DBConnection {
	
	public Connection connect(String username, String password) {
		Connection connect = null;
		String url = "jdbc:mysql://localhost:3306/catalog";
		try {
			connect = DriverManager.getConnection(url, username, password);
			System.out.println("Connection success");
			return connect;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return null;
		
	}
}
