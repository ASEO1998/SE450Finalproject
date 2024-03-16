package finalproject;

import java.util.ArrayList;

public class CartRemove {

public void removefromcart(int id, ShoppingCartInstance cart) {
		
		ArrayList<Product> productlist = cart.getCart().getProducts();
		for (int i = 0; i < productlist.size(); i ++) {
			if (productlist.get(i).getProduct_id() == id) {
				productlist.remove(productlist.get(i));
				break;
			}
		}
		
		cart.getCart().setProducts(productlist);
	}
}
