package finalproject;
import java.sql.*;
public class CatalogBook_add {

	public void addtoCatalog_Book(int id, String username, String password, Connection connect, Product product,Double price) {
		try {
			Statement st = connect.createStatement();
			
			st.executeUpdate(
		"INSERT INTO product_catalog (customer_id, product_variant, price,product_name, username,passwords)"+
			"VALUES('" + id +"', " + "'Book',"
					+ "' " + price+ "', "
					+ "'" + ((Book)product).getName() + "'," 
					+"'" + username + "',"
					+"'" + password + "'"
					+ ")"
					);
			//connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
		}
	}
}
