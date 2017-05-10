import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseServer implements iDatabaseServer {

    private ArrayList<String> products;
    DatabaseMetaData md;
    
    public DatabaseServer() throws Exception{
    	md = conn.getMetaData();
	}

	static Connection conn;

    static Statement st;

    static {
        try {
            // Step 1: Load the JDBC driver.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded.");
            // Step 2: Establish the connection to the database.
            String url = "jdbc:mysql://localhost:3306/sdj3_warehouse";

            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected to DATABASE.");

            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            e.printStackTrace();
            System.exit(0);
        }
    }
	
	@Override
	public String getRowByIDFromDatabase(int id) throws Exception {
        String row = "NULL";
        String query = ("SELECT * FROM products WHERE product_id = (SELECT product_id FROM products WHERE product_id = " + id + ")");
        ResultSet rs = st.executeQuery(query);
        int product_id = 0;
        String name = "NULL";
        String type = "NULL";
        while (rs.next()) {
            product_id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            row = product_id + "," + name + "," + type;
        }
        return row;
	}

	@Override
	public ArrayList<String> getAllProductsFromDatabase() throws Exception {
        products = new ArrayList<>();
        String query = ("SELECT * FROM products");
        ResultSet rs = st.executeQuery(query);
        int product_id = 0;
        String name = "NULL";
        String type = "NULL";
        while (rs.next()) {
            product_id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            products.add(product_id + " " + name + " " + type);
        }
        return products;
	}

	@Override
	public ArrayList<String> getAllProductsFromDatabaseWithQuantity() throws Exception {
        products = new ArrayList<>();
        String query = ("SELECT prod.product_id, prod.name, prod.type, pall.quantity FROM products prod JOIN pallets pall ON prod.product_id = pall.product_id");
        ResultSet rs = st.executeQuery(query);
        int product_id = 0;
        String name = "NULL";
        String type = "NULL";
        int quantity = 0;
        while (rs.next()) {
            product_id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            quantity = rs.getInt("quantity");
            products.add(product_id + " " + name + " " + type + " " + quantity);
        }
        return products;
	}

	@Override
	public boolean updateAddQuantityIntoDatabase(int product_id, int quantity) throws Exception {
    	String queryAdd = "UPDATE pallets SET quantity = quantity + " + quantity + " WHERE product_id = " + product_id;
        PreparedStatement preparedStmt = conn.prepareStatement(queryAdd);
        preparedStmt.execute();
        return true;
	}

	@Override
	public boolean updateSubQuantityIntoDatabase(int product_id, int quantity) throws Exception {
    	String querySub = "UPDATE pallets SET quantity = quantity - " + quantity + " WHERE product_id = " + product_id;
        PreparedStatement preparedStmt = conn.prepareStatement(querySub);
        preparedStmt.execute();
        return true;
	}

	public static void main(String[] args) throws Exception {
		
		System.out.println("Database Control Server is running...");
		DatabaseServer databaseServer = new DatabaseServer();
		
		//RMI
		iDatabaseServer rmIDatabaseControl = (iDatabaseServer)UnicastRemoteObject.exportObject(databaseServer, 0);
		Registry registry = LocateRegistry.createRegistry(1160);
		registry.bind("Database_server", rmIDatabaseControl);

	}

}
