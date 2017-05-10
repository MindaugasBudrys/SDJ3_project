import java.util.ArrayList;

public class SmallPallet {
	private int pallet_id;
    private Product product;
    private int quantity;
    private boolean toStore;

    public SmallPallet(int id, Product p, int quant, boolean store){
    	this.pallet_id = id;
        this.product = p;
        this.quantity = quant;
        this.toStore = store;
    }
    
    public int getId(){
    	return pallet_id;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity() {

        return quantity;
    }
    public boolean toStore(){
        return toStore;
    }
}
