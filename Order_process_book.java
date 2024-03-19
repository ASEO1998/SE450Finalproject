package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Order_process_book extends Order_process{

	public Product orderproduct (int get_id,Connection connect,ShoppingCartInstance cart ) {
		ProductPrice priceamount = new BookPrice();
		ProductFactory bookfactory = new BookFactory(); 
		Product book;
		double bookprice;
		
			Catalog_Get_Product get = new Catalog_Get_Product();
			ArrayList<String>details = get.productdetails(connect, get_id);
			bookprice = priceamount.price(details);
			book = bookfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),bookprice);
			book.setProduct_id(get_id);
			System.out.println("The cost for your requested product is $" + book.get_price());
			return book;
		


		
		
		
		
    
	}
}
