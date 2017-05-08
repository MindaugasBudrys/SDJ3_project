import java.sql.*;

public class TEST {
        public static void main(String[] args) throws Exception {
            int prod = 5;
            int quantity = 30;

            int totalPallets = 0;
            String query1 = ("SELECT pallet_id FROM pallets WHERE product_id =" +  prod);
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query1);
            while(rs.next())
            {
                int pal_id = rs.getInt("pallet_id");

                totalPallets += 1;
                System.out.println("Result is " + pal_id);
            }
            System.out.println("We have: " + totalPallets);

            String query2 = "INSERT INTO pallets (pallet_id, product_id, shelf_id, quantity) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE quantity = ?";



            PreparedStatement st2 = conn.prepareStatement(query2);
            st2 = conn.prepareStatement(query2);
            st2.setInt(1, totalPallets +1);
            st2.setInt(2, prod);
            st2.setInt(3, 0);
            st2.setInt(4, quantity);
            st2.setInt(5, quantity);

//            String query3 = ("UPDATE pallets SET quantity = quantity+" + quantity +" WHERE product_id = " + prod);
            st2.execute(query2);

//                        String query = ("INSERT INTO pallets (product_id, shelf_id, quantity) VALUES (?, ?, ?)");
//                        int product_id = 7;
//                        int shelf_id = 0;
//                        int quantity = 5;
//                        PreparedStatement preparedStmt = conn.prepareStatement(query);
//                        //preparedStmt.setInt (1, pallet_id);
//                        preparedStmt.setInt (1, product_id);
//                        preparedStmt.setInt (2, shelf_id);
//                        preparedStmt.setInt (3, quantity);
//                        preparedStmt.execute();
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

