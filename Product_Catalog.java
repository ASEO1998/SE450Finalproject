package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Product_Catalog {
	public void addtocatalog(Connection connect, Cart cart) {
		try {
			int index = cart.getProducts().size() - 1;
			Product newproduct = cart.getProducts().get(index);
			Statement st = connect.createStatement();
			st.executeUpdate(
					"INSERT INTO product_catalog (username,passwords,customer_id,Product_Variant"
					+ ",product_name,product_credit,features,size,product_type,price) "
					+ " VALUES ( " +
					"'"+ cart.getUsername() + "'," +
					"'"+ cart.getPassword() + "'," +
					"'"+ cart.getID() + "'," +
					"'"+ newproduct.get_variant() + "'," +
					"'"+ newproduct.get_name() + "'," +
					"'"+ newproduct.get_credit() + "'," +
					"'"+ newproduct.get_features() + "'," +
					"'"+ newproduct.get_size() + "'," +
					"'"+ newproduct.get_type() + "'," +
					"'"+ newproduct.get_price() + "'" +
					")"
					
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
