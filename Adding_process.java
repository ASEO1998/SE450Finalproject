package finalproject;

import java.sql.Connection;

public class Adding_process {
	public void add_process(Product product,Connection connect, ShoppingCartInstance cart) {
		CartAdd addtocart = new CartAdd();
		addtocart.addtocart(product, cart, connect);
		Cart_data_add dataadd = new Cart_data_add();
		dataadd.add_data(product, connect, cart);
	}
}
