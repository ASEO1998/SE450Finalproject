package finalproject;

import java.util.ArrayList;

public class CartAdd {

	public void addtocart(Product product, ShoppingCartInstance cart) {
		
		ArrayList<Product> productlist = cart.getCart().getProducts();
		productlist.add(product);
		cart.getCart().setProducts(productlist);
	}
}
