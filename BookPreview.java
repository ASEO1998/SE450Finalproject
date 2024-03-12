package finalproject;

public class BookPreview implements ProductPreview{

	@Override
	public void preview(Product product) {
		// TODO Auto-generated method stub
		System.out.println(
				((Book)product).getName()+
				"; By " + ((Book) product).getAuthor() +"\n"
				+((Book)product).getEdition() +" edition\n"
				+"Copy is " + ((Book)product).getType() +" type\n"
				+"This is a " + ((Book)product).getFeature() + " version"
				);
		
	}

}
