package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class CartRestore {
	public ArrayList<Catalog> restoreproducts (Connection connect, User_Authentication user){
		
		try {
			
			ArrayList<Catalog> catalogs = new ArrayList();
			Catalog catalog = null;
			Statement statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from cartdata WHERE username = '"
	            + user.getUsername() + "' AND passwords = '"
	            + user.getPassword() + "' AND customer_id = '"
	            + user.getCustomer_id() + "'");
	        
	      
	      
	        
	        while(resultSet.next()) {
	        	catalog = new Catalog(resultSet.getInt("product_id")
	        	,resultSet.getString("username"), 
	        	resultSet.getString("passwords"),
	        	resultSet.getInt("customer_id"),
	        	resultSet.getString("product_variant"),
	        	resultSet.getString("product_name"),
	        	resultSet.getString("product_credit"),
	        	resultSet.getString("features"),
	        	resultSet.getString("size"),
	        	resultSet.getString("product_type"), 
	        	resultSet.getDouble("price"));
	        	//System.out.println(resultSet.getString("product_name"));
	        	catalogs.add(catalog);
	        }
	        
	        
	        return catalogs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
}
