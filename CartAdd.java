package finalproject;

import java.util.ArrayList;

public class CartAdd {

	public void addtocart(Product product, Cart cart) {
		
		ArrayList<Product> productlist = cart.getProducts();
		productlist.add(product);
		cart.setProducts(productlist);
	}
}
