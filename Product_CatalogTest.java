package finalproject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Product_CatalogTest {
	Product_catalog_abstract catalog;
	DBConnection db = new DBConnection();
	/*Replace the strings for the connection with your username and password for the mysql database.*/
	Connection connect = db.connect("", "");
	String username = "TestUser";
	String password = "Testpassword";
	int customer_id = 1111;
	ArrayList<Product> products = new ArrayList();
	ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
	User_Authentication user = new User_Authentication(username, password, customer_id,false);
	Payment_deposit deposit = new Payment_deposit();
	Payment_Process payment = new Payment_Process();
	Adding_process adding = new Adding_process();
	ArrayList<String> details = new ArrayList(6);
	Order_process bookproduct = new Order_process_book();
	
	@Test
	void addcatalogtest() {
		
		ShoppingCartInstance cart =carttest;
		ArrayList<String> details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("JK Rowling");
		details.add("bought");
		details.add("second");
		details.add("digital");
		
		catalog = new ProductCatalog_Book();
		boolean check = catalog.catalog(connect, details, cart);
		assertEquals(true,check);
		
		

	}
	@Test
	void elecaddtest() {
		ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
		//ShoppingCartInstance cart =carttest;
		ArrayList<String> details = new ArrayList(6);
		details.add("Electronic");
		details.add("IPad");
		details.add("apple");
		details.add("high quality");
		details.add("XL");
		details.add("new");
		catalog = new ProductCatalog_Electronic();
		boolean check = catalog.catalog(connect, details, carttest);
		assertEquals(true,check);
	}
	
	@Test
	void clothaddtest() {
		//ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
		//ShoppingCartInstance cart =carttest;
		
		 details = new ArrayList(6);
		details.add("clothes");
		details.add("Sweater");
		details.add("Macys");
		details.add("buttons");
		details.add("XL");
		details.add("cotton");
		Product_catalog_abstract catalog = new ProductCatalog_Cloth();
		boolean check = catalog.catalog(connect, details, carttest);
		assertEquals(true,check);
	}
	@Test
	void getbook() {
		Catalog_Get_Product getproduct = new Catalog_Get_Product();
		details = getproduct.productdetails(connect, 155);
		Order_process newproduct = new Order_process_book();
		Product book = newproduct.orderproduct(155, connect, carttest);
		assertEquals(155, book.getProduct_id());
	}
	
	@Test
	void geteletronic() {
		Catalog_Get_Product getproduct = new Catalog_Get_Product();
		details = getproduct.productdetails(connect, 113);
		Order_process newproduct = new Order_process_electronic();
		Product product = newproduct.orderproduct(113, connect, carttest);
		assertEquals(113, product.getProduct_id());
	}
	
	@Test
	void getcloth() {
		Catalog_Get_Product getproduct = new Catalog_Get_Product();
		details = getproduct.productdetails(connect, 152);
		Order_process newproduct = new Order_process_cloth();
		Product product = newproduct.orderproduct(152, connect, carttest);
		assertEquals(152, product.getProduct_id());
	}

}
