package finalproject;

import java.util.ArrayList;

public class ShoppingCartInstance {
	
	private Cart CART;
	private ShoppingCartInstance(String username, String password, int id, ArrayList<Product> products) {
		System.out.println("New cart made!");
		//test = 7;
		CartBuilder builder = new CartBuilderConcrete();
		CartDirector director = new CartDirector(builder);
		Cart cart = director.createCart(username, password,id,products);
		CART = cart;
		
	}
	private static ShoppingCartInstance cart;
	
	public static ShoppingCartInstance makeCart(String username, String password,int id, ArrayList<Product> products) {
		if (cart == null) {
			cart = new ShoppingCartInstance(username, password, id, products);
		}
		else {
			System.out.println("No new cart made.");
		}
		return cart;
	}

	public Cart getCart() {
		return CART;
	}


	
}
