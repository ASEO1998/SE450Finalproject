package finalproject;

import java.sql.*;

public class Logging {

	public void log(Connection connect, boolean withdraw, ShoppingCartInstance cart, double deposit) {
		try {
			Statement statement = connect.createStatement();
			CartFinallize total = new CartFinallize();
			
			if (withdraw == true) {
				statement.executeUpdate(
						"INSERT INTO logging (customer_id,username,passwords,event_details,transactions)"+
						" VALUES ( '" + cart.getCart().getID()+ "', '" 
								+ cart.getCart().getUsername() + "' , '"
						+ cart.getCart().getPassword() 
						+ "' , 'Payment for products in cart', ' - $" + 
						total.totalcost(cart) + "')"
								);
			}
			
			else {
				statement.executeUpdate(
						"INSERT INTO logging (customer_id,username,passwords,event_details,transactions)"+
						" VALUES ( '" + cart.getCart().getID()+ "', '" + cart.getCart().getUsername() + "' , '"
						+ cart.getCart().getPassword() + "' , 'Deposit being made ', ' + $" + 
						deposit + "')"
								);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
