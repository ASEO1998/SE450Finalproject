package finalproject;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Order_process {
	abstract Product orderproduct (Connection connect, ArrayList <String> details );
}
