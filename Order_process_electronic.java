package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public class Order_process_electronic extends Order_process{

	@Override
	Product orderproduct(int get_id, Connection connect, ShoppingCartInstance cart) {
		// TODO Auto-generated method stub
		ProductPrice priceamount = new ElectronicPrice();
		ProductFactory electronicfactory = new ElectronicFactory(); 
		Product electronic;
		double electronicprice;
	
			Catalog_Get_Product get = new Catalog_Get_Product();
			ArrayList<String>details = get.productdetails(connect, get_id);
			electronicprice = priceamount.price(details);
			System.out.println(electronicprice);
			electronic = electronicfactory.createproduct(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4),  details.get(5),electronicprice);
			electronic.setProduct_id(get_id);
			System.out.println("The cost for your requested electronic product is $" + electronic.get_price());
			return electronic;
		


	}

}
