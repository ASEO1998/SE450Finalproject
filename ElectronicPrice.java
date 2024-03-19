package finalproject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ElectronicPrice implements ProductPrice{

	@Override
	public double price(ArrayList<String> details) {
		// TODO Auto-generated method stub
		double price = 0.0;
		if ((details.get(5).equalsIgnoreCase("new"))) {
			price += 13.99;
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
				
		if((details.get(3).equalsIgnoreCase("High quality"))){
			price+=10.99;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		price += 26.99;
		String format = df.format(price);
		
		return Double.parseDouble(format);
	}

}
