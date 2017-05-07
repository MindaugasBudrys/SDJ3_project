import java.sql.*;

public class TEST {
        public static void main(String[] args) throws Exception {
                        String query = ("INSERT INTO pallets (pallet_id, product_id, shelf_id, quantity) VALUES (?, ?, ?, ?)");
                        int pallet_id = 0;
                        int product_id = 5;
                        int shelf_id = 0;
                        int quantity = 2;
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setInt (1, pallet_id);
                        preparedStmt.setInt (2, product_id);
                        preparedStmt.setInt (3, shelf_id);
                        preparedStmt.setInt (4, quantity);
                        preparedStmt.execute();
                }

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

