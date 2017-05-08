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
    private int product_id;
    private String name;
    private String type;

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
                    productsList = model.getAllProductsFromDatabase();
                    for(int i = 0; i < productsList.size(); i++){
                        System.out.println(productsList.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                	HashMap<Integer, Integer> newProducts = new HashMap<>();
                    view.orderProduct();
                    
                    
                    String readString = scanner.nextLine();
                    if (readString.equals("")) {
                        System.out.println("Ok.");
                    }
                    if (scanner.hasNextLine()) {
                    	id = scanner.nextInt();
                        splitString(model.getRowByIDFromDatabase(id));
                    	quantity = scanner.nextInt();
                    	newProducts.put(id, quantity);
                    } else {
                        readString = null;
                    }
                    
                    warehouseControl.orderNewProducts(newProducts);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
            	try{
            		view.orderProductForDeparture();
            		id = scanner.nextInt();
            		quantity = scanner.nextInt();
            		splitString(model.getRowByIDFromDatabase(id));
            		warehouseControl.orderProductsForDeparture("");
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            	break;
        }
    }while (choice > 0 || choice < 9);
}
public void splitString(String string){

        String[] token = string.split(",");
        product_id = Integer.parseInt(token[0]);
        name = token[1];
        type = token[2];

    System.out.println(product_id + "/" + name + "/" + type);
}
}
