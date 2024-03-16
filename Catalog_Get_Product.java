package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Catalog_Get_Product {
	public ArrayList<String> productdetails(Connection connect, int get_id){
		ArrayList<String> productdetails = new ArrayList();
		Statement statement;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from product_catalog");
	        

	        
	        while(resultSet.next()) {
	        		if (resultSet.getInt("product_id") == get_id) {
	        			productdetails.add(resultSet.getString("Product_Variant"));
	        			productdetails.add(resultSet.getString("product_name"));
	        			productdetails.add(resultSet.getString("product_credit"));
	        			productdetails.add(resultSet.getString("features"));
	        			productdetails.add(resultSet.getString("size"));
	        			productdetails.add(resultSet.getString("product_type"));
	        			return productdetails;
	        		}
	        		
	        	}
	        System.out.println("Product id does not exist in catalog.");
	        return null;
	        
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		
		return null;
	}
}
