package finalproject;

public class Book implements Product{

	private String name;
	private String author;
	private String edition;
	private String object;
	private String type;
	private double price = 0.0;
	private String feature;
	
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
	
	public Book (String titlename, String author, String type, String edition,String feature,double price) {
		this.name = titlename;
		this.author = author;
		this.type = type;
		this.edition = edition;
		this.feature = feature;
		this.price = price;
		//pricetotal(type,edition,feature);
	}
	


	@Override
	public String get_variant() {
		// TODO Auto-generated method stub
		return object;
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

//	@Override
//	public double price() {
//		// TODO Auto-generated method stub
//		return price;
//	}

}
