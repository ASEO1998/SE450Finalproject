package finalproject;

import java.sql.Connection;

public class Removal_Process {
	public boolean remove_product(int product_id,Connection connect, ShoppingCartInstance cart,int quantity) {
		Cart_data_remove data = new Cart_data_remove();
		boolean remove1 = data.remove_from_cart(product_id, connect, cart, quantity);
		CartRemove remove = new CartRemove();
		boolean remove2 = remove.removefromcart(product_id, cart,quantity);
		
		if (remove1 ==  true && remove2 == true) {
			return true;
		}
		return false;
	}
}
