package finalproject;

public class ShoppingCartInstance {
	private int test;
	private Cart CART;
	private ShoppingCartInstance() {
		System.out.println("New cart made!");
		test = 7;
		
	}
	private static ShoppingCartInstance cart;
	
	public static ShoppingCartInstance makeCart() {
		if (cart == null) {
			cart = new ShoppingCartInstance();
		}
		else {
			System.out.println("No new cart made.");
		}
		return cart;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
}
