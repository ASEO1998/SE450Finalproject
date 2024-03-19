package finalproject;

public class Cloth implements Product{

	private String name;
	private String company;
	private String size;
	private String variant;
	private String type;
	private double price = 0.0;
	private String feature;
	private int product_id;
	
	public Cloth (String variant, String titlename, String company, String feature,String size,String type,double price) {
		this.name = titlename;
		this.company = company;
		this.type = type;
		this.size = size;
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
		return company;
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
		return size;
	}

	@Override
	public void setProduct_id(int product_id) {
		// TODO Auto-generated method stub
		this.product_id = product_id;
	}

	@Override
	public int getProduct_id() {
		// TODO Auto-generated method stub
		return product_id;
	}
}
