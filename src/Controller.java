import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    iWarehouseControl iWarehouseControl;
    View view;
    Model model;
    ArrayList<String> productsList;
    ArrayList<Product> products;

public Controller(View v, iWarehouseControl m) throws Exception{
    this.view = v;
    this.iWarehouseControl = m;
    this.model = new Model();
    productsList = new ArrayList<>();
    products = new ArrayList<Product>();
}
public void addProducts(int id, String name, String type){
    products.add(new Product(id, name, type));
}
public void createProduct(){
    String lineTxt = null;
    int id;
    String name;
    String type;
    while (lineTxt != null)
    {
        String[] token = lineTxt.split("/");
        id = Integer.parseInt(token[0].trim());
        name = token[1].trim();
        type = token[1].trim();
        addProducts(id, name, type);
    }
}

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
                    view.orderProduct();
                    id = scanner.nextInt();
                    quantity = scanner.nextInt();

                break;
        }
    }while (choice > 0 || choice < 3);
}
}
