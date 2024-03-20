package finalproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
		
		Product_catalog_abstract catalog;
		Adding_process adding = new Adding_process();
		Removal_Process removing = new Removal_Process();
		Scanner userinput = new Scanner(System.in);
		Payment_deposit deposit = new Payment_deposit();
		Payment_Process payment = new Payment_Process();
		Order_process newproduct;
		Logging log = new Logging();
		String username = "";
		String password = "";
		int customer_id;
		CartAdd add = new CartAdd();
		DBConnection db = new DBConnection();
		System.out.println("type in username for your mysql db connection");
		
		String userdb = userinput.next();
		
		System.out.println("type in password for your mysql db connection");
		
		String passdb = userinput.next();
		Connection connect = db.connect(userdb, passdb);
		Copying_process restore = new Copying_process();
		Boolean admin = false;
		System.out.println("Type username");
		username = userinput.next();
		System.out.println("Type password");
		password = userinput.next();
		System.out.println("Type id number");
		
		
		customer_id = userinput.nextInt();
		
		System.out.println("Are you an admin? Type true or false");
		String adminuser = "";
		admin = userinput.nextBoolean();
		User_Authentication user = new User_Authentication(username, password, customer_id,admin);
		CartAdd add1 = new CartAdd();
		User_check check = new User_check();
		boolean newuser = check.user_check(connect, user);
		ArrayList<Product> products = new ArrayList();
		ShoppingCartInstance carttest = ShoppingCartInstance.makeCart(username,password, customer_id, products);
		if (connect != null) {
			if ( newuser == false) {
				User_add adduser = new User_add();
				adduser.add_user(connect, user);
				Payment_New newpayment = new Payment_New();
				newpayment.newpayment(connect, user, "credit");
				
				
			}
			else {
				System.out.println("Welcome back " + username + " !");
				
				restore.copy(connect, user, carttest);
				
//				for (int i = 0; i < carttest.getCart().getProducts().size(); i++) {
//					BookPreview view = new BookPreview();
//					view.preview(carttest.getCart().getProducts().get(i));
//				}
			}
		}
		userinput = new Scanner(System.in);
		String option = "";
		if (connect != null) {
		while(!(option.equalsIgnoreCase("exit"))) {
			userinput = new Scanner(System.in);
			System.out.println("Type in the following numbers:\n"
					+ "1: Make a deposit with a payment type.\n"
					+ "2: Display all your products in the cart.\n"
					+ "3: Show the current product catalog.\n"
					+ "4: Order and create a new product of your choosing for the catalog.  This is only for admins\n"
					+ "5: Make a payment now for all your products in the cart.\n"
					+ "6: View your events and transaction log\n"
					+ "7: Remove a product from your cart.\n"
					+ "8: Add a product listed on the catalog.\n"
					+ "9: Add new payment type to the system.\n"
					+ "Type exit to leave the system.\n");
			option = userinput.next();
			
			if (option.equalsIgnoreCase("1")) {
				userinput = new Scanner(System.in);
				System.out.println("Which payament type do you want to use? Credit or check?");
				String type = "";
				while (!(type.equalsIgnoreCase("Credit")) && !(type.equalsIgnoreCase("check"))) {
					type = userinput.next();
				}
				double amount = -1.0;
				System.out.println("how much do you want depositied?");
				userinput = new Scanner(System.in);
				while ( amount < 0.0 ) {
					amount = userinput.nextDouble();
				}
				deposit.deposit(connect, user, amount, type);
				Logging_deposit d = new Logging_deposit();
				d.log_deposit(connect, false, carttest, amount);
				//log.log(connect, false, carttest, amount);
			}
			
			if (option.equalsIgnoreCase("2")) {
				userinput = new Scanner(System.in);
				Product_List list = new Product_List();
				list.list(carttest);
			}
			
			if (option.equalsIgnoreCase("3")) {
				Catalog_view view = new Catalog_view();
				view.catalog_display(connect, carttest);
			}
			
			if(option.equalsIgnoreCase("4") && user.isAdmin() == false) {
				System.out.println("admins only for this option");
			}
			
			if (option.equalsIgnoreCase("4") && user.isAdmin() == true) {
				
				
				
				ArrayList<String> details = new ArrayList(6);
				System.out.println("What kind of product do you want to make? A Book, electronic, or clothes.  Type any of those three");
				userinput = new Scanner(System.in);
				String variant = "";
				while (!((variant.equalsIgnoreCase("book")) || (variant.equalsIgnoreCase("clothes") || (variant.equalsIgnoreCase("electronic"))))) {
					variant = userinput.next();
				}
				
				details.add(variant);
				
				System.out.println("type the name of the product");
				String name = userinput.next();
				
				details.add(name);
				userinput = new Scanner(System.in);
				if (variant.equalsIgnoreCase("book")) {
					System.out.println("Type the author.");
				}
				else {
					System.out.println("Type the company the product belongs to.");
				}
				String credit = userinput.next();
				
				details.add(credit);
				userinput = new Scanner(System.in);
				String features = "";
				if (variant.equalsIgnoreCase("book")) {
					System.out.println("Do you want to buy the book or rent it?. Type bought or rental");
					while (!((features.equalsIgnoreCase("bought")) || (features.equalsIgnoreCase("rental")) 
							)) {
						features = userinput.next();
					}
				}
				
				else if (variant.equalsIgnoreCase("electronic")) {
					System.out.println("Do you want the quality of the electornic to be high or just regular. Type high or regular");
					while (!((features.equalsIgnoreCase("High quality")) || (features.equalsIgnoreCase("regular quality")) 
							)) {
						features = userinput.next() + " quality";
					}
				}
				
				else if (variant.equalsIgnoreCase("clothes")) {
					System.out.println("What features do you want for this cloth? Pockets, buttons or none?");
					boolean t = true;
					while(t == true) {
						features = userinput.next();
						if (((features.equalsIgnoreCase("none")) || (features.equalsIgnoreCase("buttons") || (features.equalsIgnoreCase("pockets")
								)))) {
							break;
						}
					}
//					while (!((features.equalsIgnoreCase("none")) | (features.equalsIgnoreCase("buttons") | (features.equalsIgnoreCase("pockets")
//							)))) {
//						features = userinput.next();
//					}
				}
				
				details.add(features);
				
				userinput = new Scanner(System.in);
				String size = "";
				if (variant.equalsIgnoreCase("book")) {
					while (true) {
						
					System.out.println("Which book editions do you want. First, second, third, or fourth? Type in any of these editions.");
					size = userinput.next();
					if (((size.equalsIgnoreCase("first")) || (size.equalsIgnoreCase("second") || (size.equalsIgnoreCase("third") ||
							(size.equalsIgnoreCase("fourth")))))) {
						break;
					}
//					while (!((size.equalsIgnoreCase("first")) || (size.equalsIgnoreCase("second") | (size.equalsIgnoreCase("third") ||
//							(size.equalsIgnoreCase("fourth")))))) {
//						size = userinput.next();
//					}
					}
				}
				else {
					
					System.out.println("What size do you want. Small, regular, large, XL? Type in any of these sizes.");
					while(true) {
						userinput = new Scanner(System.in);
						size = userinput.next();
						if(size.equalsIgnoreCase("small") || size.equalsIgnoreCase("regular") || size.equalsIgnoreCase("large") |
								size.equalsIgnoreCase("XL")) {
							break;
						}
					}
					
//					while (!((size.equalsIgnoreCase("small")) || (variant.equalsIgnoreCase("regular") || (variant.equalsIgnoreCase("large") |
//							(size.equalsIgnoreCase("XL")))))) {
//						size = userinput.next();
//					}
				}
				
				details.add(size);
				userinput = new Scanner(System.in);
				String type = "";
				if (variant.equalsIgnoreCase("book")) {
					System.out.println("Which type of copy do you want? Print or digital?");
					while (!(type.equalsIgnoreCase("print")) && !(type.equalsIgnoreCase("digital") 
							)) {
						type= userinput.next();
					}
				}
				
				else if (variant.equalsIgnoreCase("electronic")) {
					System.out.println("Do you want a used or new electornic? Type new or used");
					while (!(type.equalsIgnoreCase("used")) && !(type.equalsIgnoreCase("new") 
							)) {
						type= userinput.next();
					}
				
				}
				
				else if (variant.equalsIgnoreCase("clothes")) {
					System.out.println("What do you want this cloth to be made of? Wool, cotton, linen ");
					while (true) {
						type= userinput.next();
						if (((type.equalsIgnoreCase("cotton")) || (type.equalsIgnoreCase("linen") || (type.equalsIgnoreCase("wool") 
								)))) {
							break;
						}
						
					}
//					while (!((type.equalsIgnoreCase("cotton")) || (type.equalsIgnoreCase("linen") || (type.equalsIgnoreCase("wool") 
//							)))) {
//						type= userinput.next();
//					}
				}
				details.add(type);
								
				
				Product product = null;
				if (variant.equalsIgnoreCase("book")) {
					catalog = new ProductCatalog_Book();
					catalog.catalog(connect, details, carttest);
//					newproduct = new Order_process_book();
//					product = newproduct.orderproduct(-1, connect, details, carttest);
					
				}
				
				else if (variant.equalsIgnoreCase("electronic")) {
					catalog = new ProductCatalog_Electronic();
					catalog.catalog(connect, details, carttest);
//					newproduct = new Order_process_electronic();
//					product = newproduct.orderproduct(-1, connect, details, carttest);
					
				}
				
				else if (variant.equalsIgnoreCase("clothes")) {
					catalog = new ProductCatalog_Cloth();
					catalog.catalog(connect, details, carttest);
//					newproduct = new Order_process_electronic();
//					product = newproduct.orderproduct(-1, connect, details, carttest);
					
				}
				
				
			}
			
			
			
			if (option.equalsIgnoreCase("5")) {
				System.out.println("How do you want to pay? check or credit?");
				userinput = new Scanner(System.in);
				String pay_type = "";
				while(!(pay_type.equalsIgnoreCase("credit")) && !(pay_type.equalsIgnoreCase("check")) ) {
					pay_type = userinput.next();
				}
				payment.payment(connect, carttest, pay_type);
				//log.log(connect, true, carttest, 0);
			}
			
			if (option.equalsIgnoreCase("6")) {

				Logging_Display display = new Logging_Display();
				display.log_view(connect, carttest);
			}
			
			if (option.equalsIgnoreCase("7")) {
				System.out.println("Which product do you want to remove? Type the product id number associated to that specifc product.");
				userinput = new Scanner(System.in);
				int id = userinput.nextInt();
				userinput = new Scanner(System.in);
				System.out.println("How many do you want removed?");
				int quantity = userinput.nextInt();
				removing.remove_product(id, connect, carttest,quantity);
			}
			
			if (option.equalsIgnoreCase("8")) {
				System.out.println("Which product do you want to add to the cart. Type the product id number associated to that specific product from the catalog.");
				userinput = new Scanner(System.in);
				int id = userinput.nextInt();
				Catalog_Get_Product getproduct = new Catalog_Get_Product();
				ArrayList<String> details = getproduct.productdetails(connect, id);
//				for(int i = 0; i < details.size(); i++) {
//					System.out.println(details);
//				}
				Product product = null;
				if (details != null) {
					if (details.get(0).equalsIgnoreCase("book")) {
						newproduct = new Order_process_book();
						//System.out.println("testing");
						product = newproduct.orderproduct(id, connect, carttest);
					}
					
					else if (details.get(0).equalsIgnoreCase("electronic")) {
						newproduct = new Order_process_electronic();
						product = newproduct.orderproduct(id, connect, carttest);
					}
					
					else if (details.get(0).equalsIgnoreCase("clothes")) {
						newproduct = new Order_process_cloth();
						product = newproduct.orderproduct(id, connect, carttest);
					}
					//Product product = newproduct.orderproduct(id, connect, details, carttest);
					System.out.println("Do you wish to add this product to your cart? Type yes or no.");
					String response = "";
					if (product != null) {
						while(!(response.equalsIgnoreCase("yes")) && !(response.equalsIgnoreCase("no"))) {
							response= userinput.next();
						}
						
						if (response.equalsIgnoreCase("yes")) {
							adding.add_process(product, connect, carttest);
						}
					}
					
				}
				
			}
			
			if (option.equalsIgnoreCase("9")) {
				System.out.println("Which payment do you want to add? Check or credit?");
				userinput = new Scanner(System.in);
				String paytype= "";
				while(!(paytype.equalsIgnoreCase("check") ||  paytype.equalsIgnoreCase("credit"))) {
					paytype = userinput.next();
				}
				
				Payment_New pay = new Payment_New();
				pay.newpayment(connect, user, paytype);
			}
		}
		
		
	}
	}
	

}
