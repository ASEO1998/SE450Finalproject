package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Product_catalog_abstract {
	abstract boolean catalog(Connection connect, ArrayList <String> details,ShoppingCartInstance cart);
}
