package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductCatalog_Book extends Product_catalog_abstract{

	public boolean catalog(Connection connect, ArrayList <String> details,ShoppingCartInstance cart) {
		ProductPrice priceamount = new BookPrice();
		ProductFactory bookfactory = new BookFactory(); 
		Product book;
		double bookprice;
		bookprice = priceamount.price(details);
		book = bookfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),bookprice);
		
		Product_Catalog catalog = new Product_Catalog();
		boolean check =catalog.addtocatalog(connect, cart, book);
		Catalog_getProduct_ID id = new Catalog_getProduct_ID();
		
		if (check == true) {
			book.setProduct_id(id.get_id(connect, book, cart));
			System.out.println("ID for this new product is " + id.get_id(connect, book, cart) +" and"
					+ " cost is $" + book.get_price());
			return true;
		}
		System.out.println("Cataloging of book, failed");
		return false;
	}
}
