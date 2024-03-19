package finalproject;

import java.util.ArrayList;

public class CartRemove {

public boolean removefromcart(int id, ShoppingCartInstance cart, int quantity) {
		int count = 0;
		ArrayList<Product> productlist = cart.getCart().getProducts();
		for (int i = 0; i < productlist.size(); i ++) {
			if (productlist.get(i).getProduct_id() == id) {
				productlist.remove(productlist.get(i));
				cart.getCart().setProducts(productlist);
				count ++;
				if (count == quantity) {
					return true;
				}
				
				//break;
			}
		}
		
		cart.getCart().setProducts(productlist);
		return false;
	}
}
