import java.rmi.Remote;
import java.util.ArrayList;

public interface iDatabaseServer extends Remote {

	public String getRowByIDFromDatabase(int id) throws Exception;
	public ArrayList<String> getAllProductsFromDatabase() throws Exception;
	public ArrayList<String> getAllProductsFromDatabaseWithQuantity() throws Exception;
	public boolean updateAddQuantityIntoDatabase(int product_id, int quantity ) throws Exception;
	public boolean updateSubQuantityIntoDatabase(int product_id, int quantity ) throws Exception;

}
