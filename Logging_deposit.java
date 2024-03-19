package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Logging_deposit {

	public boolean log_deposit(Connection connect, boolean withdraw, ShoppingCartInstance cart, double deposit) {
		try {
			Statement statement = connect.createStatement();
			CartFinallize total = new CartFinallize();
			
		
			
			
				statement.executeUpdate(
						"INSERT INTO logging (customer_id,username,passwords,event_details,transactions)"+
						" VALUES ( '" + cart.getCart().getID()+ "', '" + cart.getCart().getUsername() + "' , '"
						+ cart.getCart().getPassword() + "' , 'Deposit being made ', ' + $" + 
						deposit + "')"
								);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}
}
