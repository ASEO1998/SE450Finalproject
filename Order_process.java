package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Order_process {
	abstract Product orderproduct (int get_id,Connection connect, ArrayList <String> details, ShoppingCartInstance cart );
}
