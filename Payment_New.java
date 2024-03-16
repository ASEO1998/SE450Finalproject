package finalproject;

import java.sql.*;

public class Payment_New {

	public void newpayment(Connection connect, User_Authentication user,String paymenttype) {
		
		try {
        	Statement statement = connect.createStatement();

				statement.executeUpdate("INSERT INTO accounts (customer_id,"
						+ "username,passwords,payment_type) VALUES "
						+ "("
						+ "'" + user.getCustomer_id() +"', "
						+ "'" + user.getUsername() + "', "
						+ "'" + user.getPassword() + "', "
						+ "'" + paymenttype + "' "
						+ ");");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
