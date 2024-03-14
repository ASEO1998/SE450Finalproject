package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Order_process {
	abstract void orderproduct (ArrayList <String> details, ShoppingCartInstance cart );
}
