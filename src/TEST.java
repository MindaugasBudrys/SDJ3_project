import java.sql.Connection;
import java.sql.DriverManager;

public class TEST {
    public static void main(String[] args){
        ProductSupply p = new ProductSupply();
        p.newProduct("liquid","Milk",5, 5);
        
        try {
        	Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
        	String myUrl = "jdbc:mysql://localhost:3306";
        	Connection con = DriverManager.getConnection(myUrl, "root", "");
        } catch (Exception e) {
        	System.err.println("Got an exception");
        	System.err.println(e.getMessage());
        }
    }
}
