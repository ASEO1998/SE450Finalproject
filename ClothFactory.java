package finalproject;

public class ClothFactory implements ProductFactory{

	@Override
	public Product createproduct(String variant, String name, String credit, String features, String size, String type,
			double price) {
		// TODO Auto-generated method stub
		return new Cloth(variant, name, credit, features,size,type,price);
	}

}
