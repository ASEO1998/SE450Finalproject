package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductCatalog_Electronic extends Product_catalog_abstract{

	public boolean catalog(Connection connect, ArrayList <String> details,ShoppingCartInstance cart) {
		ProductPrice priceamount = new ElectronicPrice();
		ProductFactory bookfactory = new ElectronicFactory(); 
		Product electronic;
		double price;
		price = priceamount.price(details);
		electronic = bookfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),price);
		
		Product_Catalog catalog = new Product_Catalog();
		boolean check =catalog.addtocatalog(connect, cart, electronic);
		Catalog_getProduct_ID id = new Catalog_getProduct_ID();
		
		if (check == true) {
			electronic.setProduct_id(id.get_id(connect, electronic, cart));
			System.out.println("ID for this new product is " + id.get_id(connect, electronic, cart) +" and"
					+ " cost is $" + electronic.get_price());
			return true;
		}
		System.out.println("Cataloging of electronic, failed");
		return false;
	}
}
