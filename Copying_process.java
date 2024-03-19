package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class Copying_process {
	public void copy(Connection connect,User_Authentication user,ShoppingCartInstance cart) {
		CartRestore restore = new CartRestore();
		
		ArrayList<Catalog> catalogs = restore.restoreproducts(connect, user);
		Product product = null;
		CartAdd add = new CartAdd();
		BookFactory bookfactory = new BookFactory();
		ElectronicFactory electronicfactory = new ElectronicFactory();
		ClothFactory clothfactory = new ClothFactory();
		for (int i = 0; i < catalogs.size(); i++) {
			
			if (catalogs.get(i).getProduct_Variant().equalsIgnoreCase("Book") ) {
				product = bookfactory.createproduct(catalogs.get(i).getProduct_Variant(),
						catalogs.get(i).getProduct_name(), catalogs.get(i).getProduct_credit(), 
						catalogs.get(i).getFeatures(), catalogs.get(i).getSize(), catalogs.get(i).getProduct_type(), 
						catalogs.get(i).getPrice());
				product.setProduct_id(catalogs.get(i).getProduct_id());
				add.addtocart(product, cart, connect);
			}
			
			if (catalogs.get(i).getProduct_Variant().equalsIgnoreCase("electronic") ) {
				product = electronicfactory.createproduct(catalogs.get(i).getProduct_Variant(),
						catalogs.get(i).getProduct_name(), catalogs.get(i).getProduct_credit(), 
						catalogs.get(i).getFeatures(), catalogs.get(i).getSize(), catalogs.get(i).getProduct_type(), 
						catalogs.get(i).getPrice());
				product.setProduct_id(catalogs.get(i).getProduct_id());
				add.addtocart(product, cart, connect);
			}
			
			if (catalogs.get(i).getProduct_Variant().equalsIgnoreCase("cloth") ) {
				product = clothfactory.createproduct(catalogs.get(i).getProduct_Variant(),
						catalogs.get(i).getProduct_name(), catalogs.get(i).getProduct_credit(), 
						catalogs.get(i).getFeatures(), catalogs.get(i).getSize(), catalogs.get(i).getProduct_type(), 
						catalogs.get(i).getPrice());
				product.setProduct_id(catalogs.get(i).getProduct_id());
				add.addtocart(product, cart, connect);
			}
			
			
		}
		
	}
}
