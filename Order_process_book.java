package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Order_process_book extends Order_process{

	public void orderproduct (Connection connect, ArrayList <String> details,Cart cart ) {
		
		
    
        try {
        	Statement statement = connect.createStatement();
    		ResultSet resultSet;
			resultSet = statement.executeQuery(
			    "select * from product_catalog");
			boolean check = false;
			
			while (resultSet.next()) {
				
				if (resultSet.getString("Product_Variant").equalsIgnoreCase(details.get(0))) {
					if (resultSet.getString("product_name").equalsIgnoreCase(details.get(1))) {
						if (resultSet.getString("product_credit").equalsIgnoreCase(details.get(2))) {
							if (resultSet.getString("features").equalsIgnoreCase(details.get(3))) {
								if (resultSet.getString("size").equalsIgnoreCase(details.get(4))) {
									if (resultSet.getString("product_type").equalsIgnoreCase(details.get(5))) {
										
										
											ProductFactory bookfactory = new BookFactory ();
											CartAdd add = new CartAdd();
											Product book = bookfactory.createproduct(details.get(1), 
													details.get(2), details.get(3), details.get(4), details.get(5),
													resultSet.getDouble("price"));
											add.addtocart(book, cart);
											check= true;
											break;
										
										
										
									}
								}
							}
							}
						}
					}
				
					
				
				}
			if (check == false) {
				System.out.println("No such product exists in the catalog.  Please type "
						+ "every detail listed on the catalog to get the product.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("Invalid input.  No such input exists in the catalog.");
		}
        
        int product_id;
        String product_name;
        //System.out.println("No such product exists in the catalog.");
		//return null;
	}
}
