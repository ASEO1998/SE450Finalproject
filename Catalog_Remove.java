package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Catalog_Remove {
	
	public void remove_from_catalog(int productid,Connection connect) {
		try {
			Statement st = connect.createStatement();
			
			st.executeUpdate("DELETE FROM product_catalog "
					+ "WHERE product_id = " + productid +";"
					);
		
			//connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
