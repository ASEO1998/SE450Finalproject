package finalproject;

import java.util.ArrayList;

public class CartRemove {

public void removefromcart(Product product, Cart cart) {
		
		ArrayList<Product> productlist = cart.getProducts();
		productlist.remove(product);
		cart.setProducts(productlist);
	}
}
