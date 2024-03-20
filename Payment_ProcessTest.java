package finalproject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Payment_ProcessTest {
	
	DBConnection db = new DBConnection();
	/*Replace the strings for the connection with your user name and password for the mysql database.*/
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
	void paymenttest() {
		
		ArrayList<String> details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("JK Rowling");
		details.add("bought");
		details.add("second");
		details.add("digital");
		
		Product book = bookproduct.orderproduct(78, connect, carttest);
		adding.add_process(book, connect, carttest);
		Payment_New newpayment = new Payment_New();
		newpayment.newpayment(connect, user, "credit");
		deposit.deposit(connect, user, 650.50, "credit");
		
		
		assertEquals(true, payment.payment(connect, carttest, "credit"));
		//fail("Not yet implemented");
		Product electronic = bookproduct.orderproduct(88, connect, carttest);
		adding.add_process(electronic, connect, carttest);
		assertEquals(true, payment.payment(connect, carttest, "credit"));
		Product cloth = bookproduct.orderproduct(89, connect, carttest);
		adding.add_process(cloth, connect, carttest);
		assertEquals(true, payment.payment(connect, carttest, "credit"));
	}
	@Test
	void paymenttestinsuffcient(){
		
		ArrayList<String> details = new ArrayList(6);
		details.add("Book");
		details.add("Harry Potter");
		details.add("JK Rowling");
		details.add("bought");
		details.add("second");
		details.add("digital");
		
		Product book = bookproduct.orderproduct(77, connect, carttest);
		adding.add_process(book, connect, carttest);
		Payment_New newpayment = new Payment_New();
		newpayment.newpayment(connect, user, "check");
	
		deposit.deposit(connect, user, 20.50, "check");
		assertEquals(false,payment.payment(connect, carttest, "check"));
		
		Product electronic = bookproduct.orderproduct(88, connect, carttest);
		adding.add_process(electronic, connect, carttest);
		assertEquals(false,payment.payment(connect, carttest, "check"));
		
		Product cloth = bookproduct.orderproduct(89, connect, carttest);
		adding.add_process(cloth, connect, carttest);
		assertEquals(false,payment.payment(connect, carttest, "check"));
	}
	
	

}
