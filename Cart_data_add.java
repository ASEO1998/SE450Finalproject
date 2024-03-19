package finalproject;

import java.sql.*;

public class Cart_data_add {

public boolean add_data( Product product,Connection connect,ShoppingCartInstance cart) {
	try {
		
	
		//Product newproduct = cart.getCart().getProducts().get(index);
		Statement st = connect.createStatement();
		st.executeUpdate(
				"INSERT INTO cartdata (product_id,username,passwords,customer_id,Product_Variant"
				+ ",product_name,product_credit,features,size,product_type,price) "
				+ " VALUES ( " +
				"'"+ product.getProduct_id() + "', "+
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
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println(e);
		return false;
	}
	
}
}
