import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {

    private iWarehouseControl warehouseControl;
    private View view;
    private Model model;
    private ArrayList<String> productsList;
    private ArrayList<Product> products;

public Controller(View v, iWarehouseControl m) throws Exception{
    this.view = v;
    this.warehouseControl = m;
    this.model = new Model();
    productsList = new ArrayList<>();
    }
//public void addProducts(int id, String name, String type){
//    products.add(new Product(id, name, type));
//}

//public void createProduct(){
//    String lineTxt = null;
//    int id;
//    String name;
//    String type;
//    while (lineTxt != null)
//    {
//        String[] token = lineTxt.split("/");
//        id = Integer.parseInt(token[0].trim());
//        name = token[1].trim();
//        type = token[1].trim();
//        addProducts(id, name, type);
//    }
//}

public void menu() throws RemoteException{
    int choice;
    int id;
    int quantity;
    Scanner scanner = new Scanner(System.in);

    do{
        view.menu();
        choice = scanner.nextInt();

        switch (choice) {

            case 1:
                try {
                    productsList = model.getAllProductsFromDatabaseWithQuantity();
                    for(int i = 0; i < productsList.size(); i++){
                        System.out.println(productsList.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                	ArrayList<String> newProducts = new ArrayList<String>();
                    view.orderProduct();

                    boolean keepReading = true;
                    while (keepReading) {
                    	id = scanner.nextInt();
                    	quantity = scanner.nextInt();
                    	String data = id + "," + quantity;
                    	
                    	System.out.println(("DATA: " + data));
                    	newProducts.add(data);

                    	System.out.println("Do you want to order more products? Y/N");
                    	if (scanner.next().equals("Y")){
                    		keepReading = true;
                    	} else {
                    		keepReading = false;
                    	}

                    }

                    System.out.println("Before warehouse control");
                    warehouseControl.orderNewProducts(newProducts);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
            	try{
                	ArrayList<String> newProductsForDeparture = new ArrayList<String>();
            		view.orderProductForDeparture();
            		
            		boolean keepReading = true;
                    while (keepReading) {
                    	id = scanner.nextInt();
                    	quantity = scanner.nextInt();
                    	//String data = model.getRowByIDFromDatabase(id) + "," + quantity;
                    	//System.out.println(("DATA: " + data));
                    	//newProductsForDeparture.add(data);
                    	
                    	String data = id + "," + quantity;
                    	
                    	System.out.println(("DATA: " + data));
                    	newProductsForDeparture.add(data);

                    	System.out.println("Do you want to order more products for departure? Y/N");
                    	if (scanner.next().equals("Y")){
                    		keepReading = true;
                    	} else {
                    		keepReading = false;
                    	}
                    }
            		
            		warehouseControl.orderProductsForDeparture(newProductsForDeparture);
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            	break;
        }
    }while (choice > 0 || choice < 9);
    
    }
}

