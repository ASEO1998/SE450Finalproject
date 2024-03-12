package finalproject;

public class Book implements Product{

	private String name;
	private String author;
	private String edition;
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
	
	public Book (String titlename, String author, String type, String edition,String feature) {
		this.name = titlename;
		this.author = author;
		this.type = type;
		this.edition = edition;
		this.feature = feature;
		//pricetotal(type,edition,feature);
	}
	

//	@Override
//	public void preview() {
//		// TODO Auto-generated method stub
//		System.out.println(name + "; " + author + " " + edition + " edition." +
//		type + " copy.\n "+ "Cost: $" + price );
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

//	@Override
//	public double price() {
//		// TODO Auto-generated method stub
//		return price;
//	}

}
