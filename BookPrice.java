package finalproject;

public class BookPrice implements ProductPrice{

	@Override
	public double price(Product product) {
		// TODO Auto-generated method stub
		double price = 0.0;
		if (((Book)product).getType().equalsIgnoreCase("digital")) {
			price += 15.99;
		}
		
		if(((Book)product).getEdition().equalsIgnoreCase("second")) {
			price += 5.52;
		}
		
		if(((Book)product).getEdition().equalsIgnoreCase("third")) {
			price += 8.67;
		}
		
		if (((Book)product).getEdition().equalsIgnoreCase("fourth")) {
			price+=11.21;
		}
		
		if(((Book)product).getFeature().equalsIgnoreCase("bought")){
			price+=12.99;
		}
		price += 15.99;
		return price;
	}

}
