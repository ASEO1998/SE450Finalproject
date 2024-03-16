package finalproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Product_Catalog {
	public void addtocatalog(Connection connect, ShoppingCartInstance cart, Product product) {
		try {
			
			int index = cart.getCart().getProducts().size() - 1;
			//Product newproduct = cart.getCart().getProducts().get(index);
			Statement st = connect.createStatement();
			st.executeUpdate(
					"INSERT INTO product_catalog (username,passwords,customer_id,Product_Variant"
					+ ",product_name,product_credit,features,size,product_type,price) "
					+ " VALUES ( " +
					"'"+ cart.getCart().getUsername() + "'," +
					"'"+ cart.getCart().getPassword() + "'," +
					"'"+ cart.getCart().getID() + "'," +
					"'"+ product.get_variant() + "'," +
					"'"+ product.get_name() + "'," +
					"'"+ product.get_credit() + "'," +
					"'"+ product.get_features() + "'," +
					"'"+ product.get_size() + "'," +
					"'"+ product.get_type() + "'," +
					"'"+ product.get_price() + "'" +
					")"
					
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
