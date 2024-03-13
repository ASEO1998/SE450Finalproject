package finalproject;

import java.util.ArrayList;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
		
		//Singleton section
		
		ShoppingCartInstance carttest = ShoppingCartInstance.makeCart();
		int yen = carttest.getTest();
		//System.out.println(yen);
		//ShoppingCartInstance carttest2 = ShoppingCartInstance.makeCart();
		
		
		ArrayList<Product> products = new ArrayList();
		
		ProductFactory bookfactory = new BookFactory ();
		Product book = bookfactory.createproduct("Harry Potter", "J.K. Rowling", "bought", "second", "digital",100.90);
		
		//book.preview();
		
		
		CartBuilder builder = new CartBuilderConcrete();
		CartDirector director = new CartDirector(builder);
		Cart cart = director.createCart("Aaron", "password",123,products);
		
		//System.out.println(cart.getUsername());
		CartAdd addtocart = new CartAdd();
		//director.additem(book);
		//addtocart.addtocart(book, cart);
		products = cart.getProducts();
		book = bookfactory.createproduct("Hunger games", "Raymond", "rented", "first", "digital",99.99);
		//addtocart.addtocart(book, cart);
		//director.additem(book);
		
		
		Double price = 0.0;
		
		
		DBConnection db = new DBConnection();
		Connection connect = db.connect("root", "Ll22772033$");
		if (connect == null) {
			System.out.println("Connection failed");
		}
		CatalogBook_add add = new CatalogBook_add();
		
		Order_process newproduct = new Order_process_book();
		
		ArrayList<String> details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("J.K. Rowling");
		details.add("Bought");
		details.add("first edition");
		details.add("print");
		book = newproduct.orderproduct(connect, details);
		if (book != null) {
			addtocart.addtocart(book, cart);
		}
		
		
		for(int i = 0; i < products.size(); i++) {
			//products.get(i).preview();
			BookPreview view = new BookPreview();
			view.preview(products.get(i));
			//BookPrice bookprice = new BookPrice();
			//price = bookprice.price(products.get(i));
			//System.out.println("Cost of this product is $"+price +"\n");
			//add.addtoCatalog_Book(123456, cart.getUsername(), cart.getPassword() , connect, products.get(i), price);
		}
//		
//		Catalog catalog = new Catalog();
//		catalog.catalog_display(connect);
//		Catalog_Remove remove = new Catalog_Remove();
//		remove.remove_from_catalog(18, connect);
//		catalog.catalog_display(connect);
	}
	

}
