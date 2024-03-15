package finalproject;

import java.util.ArrayList;

public class CartDirector {
	private CartBuilder cartbuilder;
	
	public CartDirector(CartBuilder cartbuilder) {
		this.cartbuilder = cartbuilder;
	}
	
	public Cart createCart(String username,String password, int ID, ArrayList<Product> products) {
		return (Cart) cartbuilder
				.setUser(username)
				.setPassword(password)
				.setID(ID)
				.setProducts(products)
				.build();
	}
	
	public void additem(Product product) {
		cartbuilder.add(product);
	}
}
