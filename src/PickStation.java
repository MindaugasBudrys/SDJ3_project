import java.util.ArrayList;
import java.util.HashMap;

public class PickStation {
    private HashMap<Product, Integer> order;

    public PickStation(){
        order = new HashMap<Product, Integer>();
    }
    public void addToOrder(ArrayList<SmallPallet> palletsFromConveyorBelt){
        Product prod = null;
        int quant = 0;
        
        for (int i = 0; i < palletsFromConveyorBelt.size(); i++) {
        	prod = palletsFromConveyorBelt.get(i).getProduct();
        	quant = palletsFromConveyorBelt.get(i).getQuantity();
        	order.put(prod, quant);
        }
    }
    
    public void resetHashMapOfProductsForDeparture() {
    	order.clear();
    }
    
    public HashMap<Product, Integer> getOrder(){
    	return order;
    }

}
