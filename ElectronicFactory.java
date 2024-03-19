package finalproject;

public class ElectronicFactory implements ProductFactory{

	@Override
	public Product createproduct(String variant, String name, String credit, String features, String size, String type,
			double price) {
		// TODO Auto-generated method stub
		return new Electronic (variant, name, credit, features,size,type,price);
	}

}
