package finalproject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Order_processTest {

	DBConnection db = new DBConnection();
	/*Replace the strings for the connection with your username and password for the mysql database.*/
	Connection connect = db.connect("", "");
	String username = "TestUser";
	String password = "Testpassword";
	int customer_id = 1111;
	ArrayList<Product> products;
	ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
	Adding_process adding = new Adding_process();
	ArrayList<String> details = new ArrayList(6);
	
	
	Order_process bookproduct = new Order_process_book();
	
	@Test
	void Bookproducttest() {
		
		
		Product book = bookproduct.orderproduct(77, connect, carttest);
		assertEquals("Harry potter",book.get_name());
		assertEquals("jk rowling",book.get_credit());
		assertEquals("second",book.get_size());
		assertEquals(50.49, book.get_price());
		assertEquals("bought",book.get_features());
		assertEquals("digital",book.get_type());
	}
	
	@Test
	void getBooktest() {
		
		Product book = bookproduct.orderproduct(90, connect,  carttest);
		assertEquals(90,book.getProduct_id());
		
		assertEquals("Harry Potter",book.get_name());
		assertEquals("JK Rowling",book.get_credit());
		assertEquals("second",book.get_size());
		assertEquals(50.49, book.get_price());
		assertEquals("bought",book.get_features());
		assertEquals("digital",book.get_type());
	}
	
	@Test
	void getEletronictest() {
		
		Product book = bookproduct.orderproduct(90, connect, carttest);
		assertEquals(90,book.getProduct_id());
		
		assertEquals("Harry Potter",book.get_name());
		assertEquals("JK Rowling",book.get_credit());
		assertEquals("second",book.get_size());
		assertEquals(50.49, book.get_price());
		assertEquals("bought",book.get_features());
		assertEquals("digital",book.get_type());
	}
	
	
}
