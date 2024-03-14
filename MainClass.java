package finalproject;

import java.util.ArrayList;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
		
		//Singleton section
		ArrayList<Product> products = new ArrayList();
		ShoppingCartInstance carttest = ShoppingCartInstance.makeCart("Aaron","password", 123, products);
		//int yen = carttest.getTest();
		//System.out.println(yen);
		//carttest = ShoppingCartInstance.makeCart(null, null, 0, products);
		
		
		
		Logging log = new Logging();
		ProductFactory bookfactory = new BookFactory ();
		Product book = bookfactory.createproduct("Harry Potter", "J.K. Rowling", "bought", "second", "digital",100.90,"Book");
		
		//book.preview();
		
		
//		CartBuilder builder = new CartBuilderConcrete();
//		CartDirector director = new CartDirector(builder);
		Cart cart = carttest.getCart();
		
		//System.out.println(cart.getUsername());
		CartAdd addtocart = new CartAdd();
		//director.additem(book);
		//addtocart.addtocart(book, cart);
		//products = cart.getProducts();
		//book = bookfactory.createproduct("Hunger games", "Raymond", "rented", "first", "digital",99.99);
		//addtocart.addtocart(book, cart);
		//director.additem(book);
		
		
		Double price = 0.0;
		
		
		DBConnection db = new DBConnection();
		Connection connect = db.connect("root", "Ll22772033$");
		if (connect == null) {
			System.out.println("Connection failed");
		}
		
		//Order_process newproduct = new Order_process_book();
		
		
		ArrayList<String> details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("J.K. Rowling");
		details.add("Bought");
		details.add("second");
		details.add("digital");
		
//		newproduct.orderproduct(connect, details,cart);
		//newproduct.orderproduct(connect, details,cart);
//		if (book != null) {
//			addtocart.addtocart(book, cart);
//		}
		Order_process order = new Order_process_book();
		order.orderproduct(details, carttest);
		
		
		Product_Catalog catalog = new Product_Catalog();
		if (carttest.getCart().getProducts().size() > 0) {
			catalog.addtocatalog(connect, carttest.getCart());
		}
		
		details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("J.K. Rowling");
		details.add("Rental");
		details.add("third");
		details.add("print");
		
		order = new Order_process_book();
		order.orderproduct(details, carttest);
		catalog.addtocatalog(connect, carttest.getCart());
		for(int i = 0; i < cart.getProducts().size(); i++) {
			//products.get(i).preview();
			BookPreview view = new BookPreview();
			view.preview(cart.getProducts().get(i));
			//BookPrice bookprice = new BookPrice();
			//price = bookprice.price(products.get(i));
			//System.out.println("Cost of this product is $"+price +"\n");
			//add.addtoCatalog_Book(123456, cart.getUsername(), cart.getPassword() , connect, products.get(i), price);
		}
		
		Payment_Process pay = new Payment_Process();
		
		pay.payment(connect, carttest, "Credit");
		log.log(connect, true, carttest, 0);
		Logging_Display logview = new Logging_Display();
		logview.log_view(connect, carttest);
//		Catalog_view catalogview = new Catalog_view();
//		catalogview.catalog_display(connect);
//		Catalog_Remove remove = new Catalog_Remove();
//		remove.remove_from_catalog(18, connect);
//		catalog.catalog_display(connect);
	}
	

}
