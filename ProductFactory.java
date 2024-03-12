package finalproject;

public interface ProductFactory {
	Product createproduct (String ProductName, String credit, String color,
			String features,String size,
			String type,
			Boolean extraFeatures);
}
