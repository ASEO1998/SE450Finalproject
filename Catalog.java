package finalproject;

public class Catalog {
	
	private int product_id;
	private String username;
	private String passwords;
	private int customer_id;
	private String Product_Variant;
	private String product_name;
	private String product_credit;
	private String features;
	private String size;
	private String product_type;
	private double price;
	
	public Catalog(int product_id, String username, String passwords, int customer_id,
			String Product_Variant,String product_name,String product_credit, String features, String size, String product_type,double price) {
		this.product_id = product_id;
		this.username = username;
		this.passwords =passwords;
		this.customer_id = customer_id;
		this.Product_Variant =Product_Variant;
		this.product_name = product_name;
		this.product_credit =product_credit;
		this.features = features;
		this.size = size;
		this.product_type = product_type;
		this.price = price;
		
		
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getProduct_Variant() {
		return Product_Variant;
	}
	public void setProduct_Variant(String product_Variant) {
		Product_Variant = product_Variant;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_credit() {
		return product_credit;
	}
	public void setProduct_credit(String product_credit) {
		this.product_credit = product_credit;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
