import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductSupply implements Serializable{

	
    private HashMap<Product, Integer> products;
    private Model model;

    String name;
    String type;
    
    public ProductSupply() throws Exception {
        products = new HashMap<Product, Integer>();
        model = new Model();
    }

    public void newProduct( int id, int quantity) throws Exception {
    	String hello = model.getRowByIDFromDatabase(id);
    	if (hello.equals("")) {
    	}
		System.out.println(hello);
    	System.out.println(model.getRowByIDFromDatabase(id));
    	splitString(model.getRowByIDFromDatabase(id));	
            System.out.println("New product "+ id + " " + name +" has been received");
            products.put((new Product(id, name, type)), quantity);
    }
    
    public void resetHashMapOfProducts(){
    	products.clear();
    }
    
    public HashMap<Product, Integer> getProducts(){
        return products;
    }
    
    

    private void splitString(String string){
        String[] token = string.split(",");
        name = token[1];
        type = token[2];
    }

}
