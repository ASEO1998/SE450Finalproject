package finalproject;

import java.util.ArrayList;

public class Product_List {
	public void list(ShoppingCartInstance cart) {
		ArrayList<Product> products = cart.getCart().getProducts();
		for(int i = 0; i < products.size(); i ++) {
			
			System.out.println(
					"ProductID: "+products.get(i).getProduct_id() + "\n"+
					products.get(i).get_name()+
					"; By " + products.get(i).get_credit() +"\n"
					+products.get(i).get_size() +" edition\n"
					+"Copy is " + products.get(i).get_type() +" type\n"
					+"This is a " + products.get(i).get_features() + " version"
					+"\nCost: " + products.get(i).get_price() + "\n") ;
		}
		
	}
}
