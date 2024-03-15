package finalproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
		
		
		
		Scanner userinput = new Scanner(System.in);
		String username = "";
		String password = "";
		int customer_id;
		CartAdd add = new CartAdd();
		DBConnection db = new DBConnection();
		Connection connect = db.connect("root", "Ll22772033$");
		
		username = userinput.next();
		password = userinput.next();
		customer_id = userinput.nextInt();
		User_Authentication user = new User_Authentication(username, password, customer_id);
		
		User_check check = new User_check();
		boolean newuser = check.user_check(connect, user);
		ArrayList<Product> products = new ArrayList();
		ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
		if (connect != null) {
			if ( newuser == false) {
				User_add adduser = new User_add();
				adduser.add_user(connect, user);
			}
			else {
				System.out.println("Welcome back " + username + " !");
				
				Statement statement;
				try {
					statement = connect.createStatement();
					ResultSet resultSet;
			        Product copy;
			        ProductFactory factory;
			        CartAdd addtoCart = new CartAdd();
			        resultSet = statement.executeQuery(
			            "select * from cartdata");
			        while(resultSet.next()) {
			        	if (resultSet.getString("username").equalsIgnoreCase(user.getUsername())
				        		&& resultSet.getString("passwords").equalsIgnoreCase(user.getPassword())	&&
				        		resultSet.getInt("customer_id") == user.getCustomer_id()) {
			        		ArrayList<String>details = new ArrayList(12);
		        			//int product_id = 
		        			details.add(Integer.toString(resultSet.getInt("product_id")));
		        			details.add(resultSet.getString("username"));
		        			details.add(resultSet.getString("password"));
		        			details.add(Integer.toString(resultSet.getInt("customer_id")));
		        			details.add(resultSet.getString("Product_Variant"));
		        			details.add(resultSet.getString("product_name"));
		        			details.add(resultSet.getString("product_credit"));
		        			details.add(resultSet.getString("features"));
		        			details.add(resultSet.getString("size"));
		        			details.add(resultSet.getString("product_type"));
		        			details.add(Double.toString(resultSet.getDouble("price")));
			        		
			        		if (resultSet.getString("Product_variant").equalsIgnoreCase("Book")) {
			        			factory = new BookFactory();
			        			//factory.createproduct(password, password, password, password, username, customer_id, password);
			        			copy = new Book(resultSet.getString("product_name"),resultSet.getString("product_credit"), resultSet.getString("product_type"), resultSet.getString("size"), 
			        					resultSet.getString("features"),resultSet.getDouble("price") ,resultSet.getString("Product_Variant") );
			        			addtoCart.addtocart(copy, carttest);
			        			
			        			
			        		}
			        			
			        		
			        	}
				}
			        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
		
		
		
		//Singleton section
		
		
		
		
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
		
		
		
		
		//Order_process newproduct = new Order_process_book();
		userinput = new Scanner(System.in);
		String one = userinput.nextLine();
		String two = userinput.nextLine();
		String three = userinput.nextLine();
		String four = userinput.nextLine();
		String five = userinput.nextLine();
		String six = userinput.nextLine();
		//String seven 
//		ArrayList<String> details = new ArrayList(7);
//		details.add("Book");
//		details.add("Harry Potter");
//		details.add("J.K. Rowling");
//		details.add("Bought");
//		details.add("second");
//		details.add("digital");
		
		ArrayList<String>details = new ArrayList(6);
//		details.add("Book");
//		details.add("Harry Potter");
//		details.add("J.K. Rowling");
//		details.add("Rental");
//		details.add("third");
//		details.add("print");
		details.add(one);
		details.add(two);
		details.add(three);
		details.add(four);
		details.add(five);
		details.add(six);
		
//		newproduct.orderproduct(connect, details,cart);
		//newproduct.orderproduct(connect, details,cart);
//		if (book != null) {
//			addtocart.addtocart(book, cart);
//		}
		Order_process order = new Order_process_book();
		order.orderproduct(connect,details, carttest);
		
		
		Product_Catalog catalog = new Product_Catalog();
//		if (carttest.getCart().getProducts().size() > 0) {
//			catalog.addtocatalog(connect, carttest.getCart());
//		}
		
		
		
		
		
		
		//catalog.addtocatalog(connect, carttest.getCart());
		for(int i = 0; i < carttest.getCart().getProducts().size(); i++) {
			//products.get(i).preview();
			BookPreview view = new BookPreview();
			view.preview(carttest.getCart().getProducts().get(i));
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
