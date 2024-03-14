package finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Order_process_book extends Order_process{

	public void orderproduct (ArrayList <String> details,ShoppingCartInstance cart ) {
		
		ProductFactory bookfactory = new BookFactory(); 
		ProductPrice priceamount = new BookPrice();
		double bookprice = priceamount.price(details);
		Product book = bookfactory.createproduct(details.get(1), details.get(2), details.get(5), details.get(4), details.get(3), bookprice, details.get(0));
		CartAdd addtocart = new CartAdd();
		//addtocart
		addtocart.addtocart(book, cart);
    
	}
}
