package finalproject;

import java.util.ArrayList;

public class CartBuilderConcrete implements CartBuilder{
	

	private String username;
	private String password;
	private ArrayList<Product> products;
	private int ID;
	
	public CartBuilderConcrete() {
		
	}
	public CartBuilderConcrete(String username,String password, ArrayList<Product> products, int ID) {
		this.username = username;
		this.password = password;
		this.products = products;
		this.ID = ID;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
		
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartBuilder setUser(String username) {
		// TODO Auto-generated method stub
		this.username = username;
		return this;
	}

	@Override
	public CartBuilder setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		return this;
	}

	@Override
	public CartBuilder setID(int ID) {
		// TODO Auto-generated method stub
		this.ID = ID;
		return this;
	}

	@Override
	public void finalize(ArrayList<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart build() {
		// TODO Auto-generated method stub
		return new Cart(this);
	}
	
	public String getUsername() {
		return username;
	}

	

	public ArrayList<Product> getProducts() {
		return products;
	}

	

	public String getPassword() {
		return password;
	}

	public int getID() {
		return ID;
	}

	@Override
	public CartBuilder setProducts(ArrayList<Product> products) {
		// TODO Auto-generated method stub
		this.products = products;
		return this;
	}

}
