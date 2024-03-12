package finalproject;

public class BookFactory implements ProductFactory{

	
	@Override
	public Product createproduct(String ProductName, String credit, String color, String features, String size, String type,
			Boolean extraFeatures) {
		// TODO Auto-generated method stub
		return new Book (ProductName, credit, type, size,features);
	}

}
