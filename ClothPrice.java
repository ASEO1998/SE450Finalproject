package finalproject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ClothPrice implements ProductPrice{

	@Override
	public double price(ArrayList<String> details) {
		// TODO Auto-generated method stub
		double price = 0.0;
		if ((details.get(5).equalsIgnoreCase("wool"))) {
			price += 13.99;
		}
		
		if ((details.get(5).equalsIgnoreCase("cotton"))) {
			price += 15.99;
		}
		
		if ((details.get(5).equalsIgnoreCase("linen"))) {
			price += 11.99;
		}
		if((details.get(4)).equalsIgnoreCase("small")) {
			price += 3.52;
		}
		
		if((details.get(4)).equalsIgnoreCase("regular")) {
			price += 5.52;
		}
		
		if((details.get(4)).equalsIgnoreCase("large")) {
			price += 7.52;
		}
		
		if((details.get(4)).equalsIgnoreCase("XL")) {
			price += 9.52;
		}
				
		if((details.get(3).equalsIgnoreCase("buttons"))){
			price+=5.99;
		}
		
		if((details.get(3).equalsIgnoreCase("pockets"))){
			price+=5.99;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		price += 10.99;
		String format = df.format(price);
		
		return Double.parseDouble(format);
	}

}
