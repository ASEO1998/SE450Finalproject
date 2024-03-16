package finalproject;

import java.util.ArrayList;

public class Payment_Clear_Cart {

	public void clear_cart(ShoppingCartInstance cart) {
		
		ArrayList<Product> products = cart.getCart().getProducts();
		for (int i = 0; i < products.size();i++) {
			products.remove(products.get(i));
		}
		
		cart.getCart().setProducts(products);
	}
}
