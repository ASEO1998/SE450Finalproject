package finalproject;

import java.sql.*;

public class Payment_deposit {
	public void deposit(Connection connect, User_Authentication user, double amount, String paymenttype) {
		
		try {
        	Statement statement = connect.createStatement();


				statement.executeUpdate(""
						+ "UPDATE accounts "
						+ "SET Balance = Balance + " + amount + " WHERE "
						+ " username = '" + user.getUsername() +"' AND "
			    + " passwords = '" +user.getPassword() + "' AND"
			    + " customer_id = '" + user.getCustomer_id() + "' AND"
			    + " payment_type = '" + paymenttype + "' "
						+ "");
				
				System.out.println("You have depositied $" + amount +" in your account.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
