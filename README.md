# SE450Finalproject

// the main class will ask you to do the following
CartAdd add = new CartAdd();
		DBConnection db = new DBConnection();
		System.out.println("type in username for your mysql db connection");
		
		String userdb = userinput.next();
		
		System.out.println("type in password for your mysql db connection");
		
		String passdb = userinput.next();
		Connection connect = db.connect(userdb, passdb);
  //This is necessary because the project uses mysql database to store certain info and for users who are making a return.

  Also, for you are running the junit tests, replace the strings with your username and password for the Connection to mysql.
The hostname for the url is under localhost with a portnumber of 3306.  You may change the url string in the DBConnection.java if you like.  

String url = "jdbc:mysql://localhost:3306/catalog";

  /*Replace the strings for the connection with your username and password for the mysql database.*/
	Connection connect = db.connect("", "");

 When running the mainclass, it will ask you for a username, password, and id number for the shopping cart information.  It will even ask you if you are the admin or not.  
 You can type either true or false, but this important if you select true.  Otherwise, it will prevent you from choosing option for in the system.

 Once you get that done, it give these list of options:
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

Just type the number option and that process will execute.  

Before you do anything else, I recommend that you start with option 9 to add your payment type account and then deposit how much you want into it.  Otherwise, your payment process will be considered insuffcient so you will not be able to pay your products.  Another thing you should do first is to select option 4, if you are the admin.  This will add new products to the catalog table and that, you'll be able to reive any products listed on the catalog with the specific product id number.  Otherwise, you'll receive nothing from the empty catalog table.  Once you get all that done, you'll be fully set!  Also, I recommend using the same username, passowrd, and id number for the shopping system in every running execution for the main class.  The reason is why is because all of the cart data you had before exiting the system will be restored to your cart whicb saves you the trouble of adding those products again.  
