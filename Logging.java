package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class Logging {

	public boolean log(Connection connect, boolean withdraw, ShoppingCartInstance cart, double deposit) {
		try {
			Statement statement = connect.createStatement();
			CartFinallize total = new CartFinallize();
			String products = "List of Product in cart:\n ";
			ArrayList<Product> list = cart.getCart().getProducts();
			for(int i = 0; i < list.size(); i++) {
				products = products.concat(list.get(i).get_name() +"  " + list.get(i).get_price() + "\n");
			}
			
				statement.executeUpdate(
						"INSERT INTO logging (customer_id,username,passwords,event_details,transactions)"+
						" VALUES ( '" + cart.getCart().getID()+ "', '" 
								+ cart.getCart().getUsername() + "' , '"
						+ cart.getCart().getPassword() 
						+ "' , '"+  products +"', ' - $" + 
						total.totalcost(cart) + "')"
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
