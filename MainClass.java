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
		Product book = bookfactory.createproduct("Harry Potter", "J.K. Rowling", null, "bought", "second", "digital", false);
		
		//book.preview();
		
		
		CartBuilder builder = new CartBuilderConcrete();
		CartDirector director = new CartDirector(builder);
		Cart cart = director.createCart("Aaron", "password",123,products);
		
		//System.out.println(cart.getUsername());
		CartAdd addtocart = new CartAdd();
		//director.additem(book);
		addtocart.addtocart(book, cart);
		products = cart.getProducts();
		book = bookfactory.createproduct("Hunger games", "Raymond", null, "rented", "first", "digital", false);
		addtocart.addtocart(book, cart);
		//director.additem(book);
		
		
		Double price = 0.0;
		
		
		DBConnection db = new DBConnection();
		Connection connect = db.connect("root", "Ll22772033$");
		if (connect == null) {
			System.out.println("Connection failed");
		}
		CatalogBook_add add = new CatalogBook_add();
		
		
		for(int i = 0; i < products.size(); i++) {
			//products.get(i).preview();
			BookPreview view = new BookPreview();
			view.preview(products.get(i));
			BookPrice bookprice = new BookPrice();
			price = bookprice.price(products.get(i));
			System.out.println("Cost of this product is $"+price +"\n");
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
