import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    private ArrayList<String> products;
    private iDatabaseServer databaseServer ;

    public Model() throws Exception {
		Registry registry = LocateRegistry.getRegistry("localhost", (new Integer(1160)).intValue());
		databaseServer = (iDatabaseServer) (registry.lookup("Database_server"));
    }

    public void addProductToList(int id, String name, String type) throws Exception, RemoteException{
        products = new ArrayList<String>();
        products.add(id + " " + name + " " + type );
    }
    
    public ArrayList<String> getAllProducts(){
        return products;
    }

    
    public boolean updateAddQuantityIntoDatabase(int product_id, int quantity) throws Exception {
    	return databaseServer.updateAddQuantityIntoDatabase(product_id, quantity);
    }
    
    
    public boolean updateSubQuantityIntoDatabase(int product_id, int quantity) throws Exception {
    	return databaseServer.updateSubQuantityIntoDatabase(product_id, quantity);
    }
    

	public ArrayList<String> getAllProductsFromDatabase() throws Exception {
		return databaseServer.getAllProductsFromDatabase();
	}
	
	public ArrayList<String> getAllProductsFromDatabaseWithQuantity() throws Exception {
		return databaseServer.getAllProductsFromDatabaseWithQuantity();
	}
    

	public String getRowByIDFromDatabase(int id) throws Exception {
		return databaseServer.getRowByIDFromDatabase(id);
	}
	
	
}
