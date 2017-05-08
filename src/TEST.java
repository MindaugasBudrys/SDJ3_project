import java.sql.*;

public class TEST {
	public static void main(String[] args) throws Exception {
            int prod = 5;
            int quantity = 66;

            int totalPallets = 0;
            String query1 = ("SELECT pallet_id FROM pallets WHERE product_id =" +  prod);
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query1);
            if (!rs.first()){
                System.out.println("The pallet has not been created for this product_id");
                //So, we insert new row in pallets
                String queryCheckNextPalletId = "SELECT COUNT(pallet_id) as nextPalletId FROM pallets";
                Statement stNewPalletId = conn.createStatement();
                ResultSet rsNewPalletId = stNewPalletId.executeQuery(queryCheckNextPalletId);
                rsNewPalletId.next();
                int nextPalletId = rsNewPalletId.getInt("nextPalletId");
                System.out.println(nextPalletId);
                
                String queryNewPallet = "INSERT INTO pallets (pallet_id, product_id, shelf_id, quantity) VALUES (" + nextPalletId + ", " + prod + ",0," + quantity + ")";
                Statement stInsertNewPallet = conn.createStatement();
                stInsertNewPallet.execute(queryNewPallet);
            } else {
            	
            
            while(rs.next())
            {
                int pal_id = rs.getInt("pallet_id");

                totalPallets += 1;
                System.out.println("Result is " + pal_id);
            }
            System.out.println("We have: " + totalPallets);
            
            
            String query2 = "UPDATE pallets SET quantity = quantity + 20 WHERE product_id = " + prod;

            //String query2 = "INSERT INTO pallets (pallet_id, product_id, shelf_id, quantity) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE quantity = ?";



            PreparedStatement st2 = conn.prepareStatement(query2);
            //st2 = conn.prepareStatement(query2);
            //st2.setInt(5, quantity);

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
			System.out.println("Got Connection.");

			st = conn.createStatement();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			e.printStackTrace();
			System.exit(0);
		}
	}

}
