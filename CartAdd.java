package finalproject;

import java.sql.*;
import java.util.ArrayList;

public class CartAdd {

	public void addtocart(Product product, ShoppingCartInstance cart,Connection connect) {
		
		ArrayList<Product> productlist = cart.getCart().getProducts();
		
		
		productlist.add(product);
		
		cart.getCart().setProducts(productlist);
		
	}
}
