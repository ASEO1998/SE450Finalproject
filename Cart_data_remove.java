package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cart_data_remove {

	public void remove_from_cart(int productid,Connection connect, ShoppingCartInstance cart) {
		try {
			Statement st = connect.createStatement();
			
			st.executeUpdate("DELETE FROM cartdata "
					+ "WHERE product_id = " + productid +" AND "
					+ "username = '" + cart.getCart().getUsername() + "' AND "
					+ "passwords = '" + cart.getCart().getPassword() + "' AND "
					+ "customer_id = '" + cart.getCart().getID() + "' "
					);
		
			//connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
