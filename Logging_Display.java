package finalproject;

import java.sql.*;

public class Logging_Display {
	
	public void log_view(Connection connect, ShoppingCartInstance cart) {
		Statement statement;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from logging WHERE "
	            + "customer_id = '" + cart.getCart().getID() + "' AND "
	            + "username = '" + cart.getCart().getUsername() + "' AND "
	            + "passwords = '" + cart.getCart().getPassword() + "'"
	            
	        		);
	        
	        int product_id;
	        String product_name;
	        Double price = 0.0;
	        
	        while(resultSet.next()) {
	        	System.out.println(
	        		"Event details:" + resultSet.getString("event_details") +
	        		"\nTransactions made: " + resultSet.getString("transactions") +
	        		"\nTime of event: " + resultSet.getTimestamp("time_event")
	        		+"\n"	
	        			
	        			);
	        }
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
