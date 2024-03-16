package finalproject;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class BookPrice implements ProductPrice{

	@Override
	public double price(ArrayList<String> details) {
		// TODO Auto-generated method stub
		double price = 0.0;
		if ((details.get(5).equalsIgnoreCase("digital"))) {
			price += 15.99;
		}
		
		if((details.get(4)).equalsIgnoreCase("second")) {
			price += 5.52;
		}
		
		if((details.get(4)).equalsIgnoreCase("third")) {
			price += 7.52;
		}
		
		if((details.get(4)).equalsIgnoreCase("fourth")) {
			price += 9.52;
		}
				
		if((details.get(3).equalsIgnoreCase("bought"))){
			price+=12.99;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		price += 15.99;
		String format = df.format(price);
		
		return Double.parseDouble(format);
	}

}
