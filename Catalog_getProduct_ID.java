package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Catalog_getProduct_ID {
	
	public int get_id(Connection connect, Product product, ShoppingCartInstance cart) {
		Statement statement;
		int id = -1;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from product_catalog WHERE "
	            + " username = '" + cart.getCart().getUsername()+ "' AND "
	            + " passwords = '" + cart.getCart().getPassword()+ "' AND "
	            + " customer_id = '" + cart.getCart().getID()+ "' AND"
	            + " Product_Variant = '" + product.get_variant() + "' AND "
	            + " product_name = '" + product.get_name() + "' AND "
	            + " product_credit = '" + product.get_credit() + "' AND "
	            + " features = '" + product.get_features() + "' AND "
	            + " size = '" + product.get_size() + "' AND "
	            + " product_type = '" + product.get_type() +"' "
	            );
	        
	        while(resultSet.next()) {
	        	id = resultSet.getInt("product_id");
	        }
	        
	       return id;
	        
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return -1;
	}
}
