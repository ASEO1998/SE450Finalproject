package finalproject;

public class Book implements Product{

	private String name;
	private String author;
	private String edition;
	private String variant;
	private String type;
	private double price = 0.0;
	private String feature;
	private int product_id;
	
	
//	private void pricetotal(String type, String edition,String feature) {
//		
//		
//		if(type.equalsIgnoreCase("digital")) {
//			price += 20.0;
//		}
//		
//		if (edition.equalsIgnoreCase("second")) {
//			price +=15.0;
//		}
//		
//		if (feature.equalsIgnoreCase("buy")) {
//			price += 12.0;
//		}
//		price += 25.0;
//		
//	}
	
	



	public Book (String titlename, String author, String type, String edition,String feature,double price,String variant) {
		this.name = titlename;
		this.author = author;
		this.type = type;
		this.edition = edition;
		this.feature = feature;
		this.price = price;
		this.variant = variant;
		//pricetotal(type,edition,feature);
	}
	


	@Override
	public String get_variant() {
		// TODO Auto-generated method stub
		return variant;
	}


	@Override
	public String get_name() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public String get_credit() {
		// TODO Auto-generated method stub
		return author;
	}


	@Override
	public String get_features() {
		// TODO Auto-generated method stub
		return feature;
	}


	@Override
	public String get_type() {
		// TODO Auto-generated method stub
		return type;
	}


	@Override
	public Double get_price() {
		// TODO Auto-generated method stub
		return price;
	}



	@Override
	public String get_size() {
		// TODO Auto-generated method stub
		return edition;
	}
	
	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

//	@Override
//	public double price() {
//		// TODO Auto-generated method stub
//		return price;
//	}

}
