package finalproject;

import java.util.ArrayList;

public class CartRemove {

public void removefromcart(Product product, ShoppingCartInstance cart) {
		
		ArrayList<Product> productlist = cart.getCart().getProducts();
		productlist.remove(product);
		cart.getCart().setProducts(productlist);
	}
}
