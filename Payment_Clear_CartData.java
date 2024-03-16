package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment_Clear_CartData {

	public void remove_from_cart(Connection connect, ShoppingCartInstance cart) {
		try {
			Statement st = connect.createStatement();
			
			st.executeUpdate("DELETE FROM cartdata WHERE "
					
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
