package finalproject;

import java.util.ArrayList;

public class CartFinallize {
	public double totalcost(ShoppingCartInstance cart) {
		ArrayList<Product> products = cart.getCart().getProducts();
		double total = 0.0;
		for (int i = 0; i < products.size(); i ++) {
			total += products.get(i).get_price();
		}
		return total;
	}
}
