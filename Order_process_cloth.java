package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class Order_process_cloth extends Order_process {

	@Override
	Product orderproduct(int get_id, Connection connect,ShoppingCartInstance cart) {
		// TODO Auto-generated method stub
		ProductPrice priceamount = new ElectronicPrice();
		ProductFactory clothfactory = new ClothFactory(); 
		Product cloth;
		double clothprice;

			Catalog_Get_Product get = new Catalog_Get_Product();
			ArrayList<String>details = get.productdetails(connect, get_id);
			clothprice = priceamount.price(details);
			cloth = clothfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),clothprice);
			cloth.setProduct_id(get_id);
			System.out.println("The cost for your requested product is $" + cloth.get_price());
			return cloth;
		


		
		
		
	}

}
