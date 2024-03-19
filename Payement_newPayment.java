package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Payement_newPayment {

	public void newpaymenttype(Connection connect, User_Authentication user, double amount, String paymenttype) {
		
		try {
        	Statement statement = connect.createStatement();


						
				statement.executeUpdate("INSERT INTO accounts (customer_id,"
						+ "username,passwords,payment_type,Balance) VALUES "
						+ "("
						+ "'" + user.getCustomer_id() +"', "
						+ "'" + user.getUsername() + "', "
						+ "'" + user.getPassword() + "', "
						+ "'" + paymenttype + "', "
						+ "'" + amount + "'"
						+ ");");
				System.out.println("You have depositied $" + amount +" in your account.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
