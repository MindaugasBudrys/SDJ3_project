import java.sql.*;

public class TEST {
        public static void main(String[] args) throws Exception {
            DatabaseMetaData md = conn.getMetaData();
            String sql = ("SELECT * FROM products WHERE product_id = (SELECT product_id FROM products WHERE product_id = 3)");
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getInt("product_id"));
                System.out.print(rs.getString("name"));
                System.out.println(rs.getString("type"));
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
                System.out.println("Got Connection.");

                st = conn.createStatement();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                e.printStackTrace();
                System.exit(0);
            }
        }
}

