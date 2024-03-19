package finalproject;

import java.util.ArrayList;

public class Payment_Clear_Cart {

	public void clear_cart(ShoppingCartInstance cart) {
		
		ArrayList<Product> products = cart.getCart().getProducts();
		cart.getCart().getProducts().removeAll(products);
	
		
		
	}
}
