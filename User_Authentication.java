package finalproject;

public class User_Authentication {
	private String username;
	private String password;
	private int customer_id;
	private boolean admin = false;
	User_Authentication(String username, String password, int customer_id,boolean admin){
		this.username = username;
		this.password = password;
		this.customer_id = customer_id;
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
}
