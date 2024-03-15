package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class CartRestore {
	public ArrayList<String> restoreproducts (Connection connect, User_Authentication user, ShoppingCartInstance cart){
		
		try {
			Statement statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from cartdata");
	        
	        ArrayList<String> details = new ArrayList(6);
			details.add("Book");
			details.add("Harry Potter");
			details.add("J.K. Rowling");
			details.add("Bought");
			details.add("second");
			details.add("digital");
	      
	        
	        while(resultSet.next()) {
	        	if (resultSet.getString("username").equalsIgnoreCase(user.getUsername())
		        		&& resultSet.getString("passwords").equalsIgnoreCase(user.getPassword())	&&
		        		resultSet.getInt("customer_id") == user.getCustomer_id()) {
//	        			details = new ArrayList(12);
//	        			//int product_id = 
//	        			details.add(Integer.toString(resultSet.getInt("product_id")));
//	        			details.add(resultSet.getString("username"));
//	        			details.add(resultSet.getString("password"));
//	        			details.add(Integer.toString(resultSet.getInt("customer_id")));
//	        			details.add(resultSet.getString("Product_Variant"));
//	        			details.add(resultSet.getString("product_name"));
//	        			details.add(resultSet.getString("product_credit"));
//	        			details.add(resultSet.getString("password"));
	        		
	        	}
	        	
	        }
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
}
