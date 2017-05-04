import java.io.Serializable;
import java.util.ArrayList;

public class ProductSupply implements Serializable{

    private ArrayList<Product> products;

    public ProductSupply() {
        products = new ArrayList<Product>();
    }

    public void newProduct(String type, String name, int id, int quantity) {
        for (int i = 1; i <= quantity; i++) {
            products.add(new Product(type, name, id));
        }
    }
}
