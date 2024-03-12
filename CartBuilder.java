package finalproject;

import java.util.ArrayList;

public interface CartBuilder {
	void add (Product product);
	void remove (Product product);
	CartBuilder setUser(String username);
	CartBuilder setPassword(String password);
	CartBuilder setID (int ID);
	CartBuilder setProducts (ArrayList<Product> products);
	void finalize (ArrayList<Product> products);
	Cart build ();
}
