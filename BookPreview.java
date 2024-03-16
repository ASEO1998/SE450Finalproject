package finalproject;

public class BookPreview implements ProductPreview{

	@Override
	public void preview(Product product) {
		// TODO Auto-generated method stub
		System.out.println(
				"ProductID: "+product.getProduct_id() + "\n"+
				((Book)product).get_name()+
				"; By " + ((Book) product).get_credit() +"\n"
				+((Book)product).get_size() +" edition\n"
				+"Copy is " + ((Book)product).get_type() +" type\n"
				+"This is a " + ((Book)product).get_features() + " version"
				+"\nCost: " + ((Book)product).get_price() + "\n") ;
		
	}

}
