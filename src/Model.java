import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    private ArrayList<String> products;
    DatabaseMetaData md;

    public Model() throws Exception{
        products = new ArrayList<String>();
        md = conn.getMetaData();
    }
    public void addAllProductsToArrayList() throws Exception{
        String sql = ("SELECT * FROM products");
        ResultSet rs = st.executeQuery(sql);
        int id = 0;
        String name = "NULL";
        String type = "NULL";
        while (rs.next()) {
            id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            addProductToList(id, name, type);
        }  }

    static Connection conn;

    static Statement st;

    static {
        try {
            // Step 1: Load the JDBC driver.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded.");
            // Step 2: Establish the connection to the database.
            String url = "jdbc:mysql://localhost:3306/sdj3_schema";

            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected to DATABASE.");

            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void addProductToList(int id, String name, String type) throws Exception, RemoteException{
        products.add(id + "/" + name + "/" + type );
    }
    public ArrayList<String> getAllProducts(){
        return products;
    }

}
