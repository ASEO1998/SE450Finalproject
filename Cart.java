package finalproject;

import java.util.ArrayList;

public class Cart {
	private String username;
	private String password;
	private ArrayList<Product> products;
	private int ID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	Cart(CartBuilderConcrete builder) {
		this.username = builder.getUsername();
		this.password = builder.getPassword();
		this.ID = builder.getID();
		this.products = builder.getProducts();
	}
}
