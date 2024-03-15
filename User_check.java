package finalproject;

import java.sql.*;

public class User_check {
	public boolean user_check(Connection connect,User_Authentication user) {
		
		Statement statement;
		try {
			statement = connect.createStatement();
			ResultSet resultSet;
		    
	        resultSet = statement.executeQuery(
	            "select * from authentication");
	        
	        while(resultSet.next()) {
	        	if (resultSet.getString("username").equalsIgnoreCase(user.getUsername())
	        		&& resultSet.getString("passwords").equalsIgnoreCase(user.getPassword())	&&
	        		resultSet.getInt("customer_id") == user.getCustomer_id()) {
	        		return true;
	        	}
	        }
	        System.out.println("Username, password and id not in the system.  Placing it as a new user to the system.");
	        return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		
		return false;
	}
}
