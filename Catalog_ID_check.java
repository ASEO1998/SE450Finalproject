package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Catalog_ID_check {
	public boolean Catalog_ID_check(Connection connect, int id) {
		
		Statement statement;
        try {
			statement = connect.createStatement();
			ResultSet resultSet;
        
	        resultSet = statement.executeQuery(
	            "select * from product_catalog");

	        
	        while(resultSet.next()) {
	        	
	        		if (resultSet.getInt("product_id") == id) {
	        			return true;
	        		}
	        	}

	        
	        //System.out.println("Total cost is $" + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}
}
