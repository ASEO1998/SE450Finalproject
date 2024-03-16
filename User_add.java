package finalproject;

import java.sql.*;

public class User_add {
	public void add_user(Connection connect, User_Authentication user) {
		
		Statement st;
		try {
			st = connect.createStatement();
			st.executeUpdate(
					"INSERT INTO authentication (customer_id, username, passwords)" 
					+ " VALUES ( " + user.getCustomer_id() +
					", '"+ user.getUsername() + "'" +
					", '" + user.getPassword()+ "'" +
					")"
					
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
