package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Catalog_view {
	
	public void catalog_display (Connection connect, ShoppingCartInstance cart) {
		
		Statement statement;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from product_catalog WHERE username = '"+
	            cart.getCart().getUsername() + "' AND passwords = '"
	            + cart.getCart().getPassword() + "' AND customer_id = '"
	            + cart.getCart().getID() + "' "
	        		);

	        
	        while(resultSet.next()) {
	        	//if resultSet.getString("")
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
	        	//price += resultSet.getDouble("price");
	        
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
        
	}
}
