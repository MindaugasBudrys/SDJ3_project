import java.util.ArrayList;
import java.util.HashMap;

public class PickStation {
    private HashMap<Product, Integer> order;

    public PickStation(){
        order = new HashMap<Product, Integer>();
    }
    public void addToOrder(Product p, int i){
        order.put(p, i);
    }

}
