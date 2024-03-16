package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Cart_data {

	public ArrayList<Catalog> cataloglist(Connection connect ){
		
		Statement statement;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from cart_data");
	        
	        int product_id;
	        String product_name;
	        Double price = 0.0;
	        
	        while(resultSet.next()) {
	        	
	        		System.out.println(
	        				"ID: " + resultSet.getInt("product_id") +"\n" +
	        				"Product type: "+ resultSet.getString("Product_Variant")
	        				+": "+ resultSet.getString("product_name") + "\n" +"By "
	        				+ resultSet.getString("product_credit") +
	        				"\n" + resultSet.getString("features") +
	        				"\n " + resultSet.getString("size") +
	        				"\n " + resultSet.getString("product_type")
	        				+"\nCost: "+resultSet.getDouble("price") +"\n"
	        				);
	        		
	        	}
	        	price += resultSet.getDouble("price");
	        
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
}
