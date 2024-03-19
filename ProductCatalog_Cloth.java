package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class ProductCatalog_Cloth extends Product_catalog_abstract{

	@Override
	boolean catalog(Connection connect, ArrayList<String> details, ShoppingCartInstance cart) {
		// TODO Auto-generated method stub
		ProductPrice priceamount = new ClothPrice();
		ProductFactory clothfactory = new ClothFactory(); 
		Product cloth;
		double clothprice;
		clothprice = priceamount.price(details);
		cloth = clothfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),clothprice);
		
		Product_Catalog catalog = new Product_Catalog();
		boolean check =catalog.addtocatalog(connect, cart, cloth);
		Catalog_getProduct_ID id = new Catalog_getProduct_ID();
		
		if (check == true) {
			cloth.setProduct_id(id.get_id(connect, cloth, cart));
			System.out.println("ID for this new product is " + id.get_id(connect, cloth, cart) +" and"
					+ " cost is $" + cloth.get_price());
			return true;
		}
		System.out.println("Cataloging of cloth, failed");
		return false;
	}

}
