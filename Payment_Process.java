package finalproject;

import java.sql.*;

public class Payment_Process {
	
	public boolean payment(Connection connect, ShoppingCartInstance cart ,String paymenttype) {
		
		Payment_Table updatetable = new Payment_Table();
		Payment_Clear_Cart removecart = new Payment_Clear_Cart();
		Payment_Clear_CartData removecartdata = new Payment_Clear_CartData();
		Logging log = new Logging();
		if (updatetable.payment(connect, cart, paymenttype)== true) {
			log.log(connect, true, cart, 0);
			removecart.clear_cart(cart);
			removecartdata.remove_from_cart(connect, cart);
			return true;
		} 
		
		return false;
		
		
	}

}
