import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductSupply implements Serializable{

    private HashMap<Product, Integer> products;

    public ProductSupply() {
        products = new HashMap<Product, Integer>();
    }

    public void newProduct( int id, String name, String type, int quantity) throws RemoteException {
            System.out.println("New product "+ name +" has been received");
            products.put((new Product(id, name, type)), quantity);
    }
    public HashMap<Product, Integer> getProducts(){
        return products;
    }
}
