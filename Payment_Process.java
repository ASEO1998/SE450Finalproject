package finalproject;

import java.sql.*;

public class Payment_Process {
	
	public void payment(Connection connect, ShoppingCartInstance cart ,String paymenttype) {
		
    
        try {
        	System.out.println("In payment");
        	Statement statement = connect.createStatement();
    		ResultSet resultSet;
    		double cost = 0.0;
    		CartFinallize finalize = new CartFinallize();
			resultSet = statement.executeQuery(
			    "select * from accounts"
//			    + " username = '" + cart.getCart().getUsername() +"' AND "
//			    + " passwords = '" +cart.getCart().getPassword() + "' AND"
//			    + " customer_id = '" + cart.getCart().getID() + "' AND"
//			    + " payment_type = '" + paymenttype + "' "
					);
			
			while (resultSet.next()) {
				cost = resultSet.getDouble("Balance") - finalize.totalcost(cart) ;
				
			}
			statement = connect.createStatement();
			if (cost  >= 0.0) {
				statement.executeUpdate(""
						+ "UPDATE accounts "
						+ "SET Balance = " + cost + " WHERE "
						+ " username = '" + cart.getCart().getUsername() +"' AND "
			    + " passwords = '" +cart.getCart().getPassword() + "' AND"
			    + " customer_id = '" + cart.getCart().getID() + "' AND"
			    + " payment_type = '" + "Credit" + "' "
						+ "");
			}
			else {
				System.out.println("Insuffcient Amount.  Payment cancelled");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}

}
