package finalproject;

import java.sql.Connection;

public class Removal_Process {
	public void remove_product(int product_id,Connection connect, ShoppingCartInstance cart) {
		Cart_data_remove data = new Cart_data_remove();
		data.remove_from_cart(product_id, connect, cart);
		CartRemove remove = new CartRemove();
		remove.removefromcart(product_id, cart);
	}
}
