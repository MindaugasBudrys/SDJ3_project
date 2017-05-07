import java.util.ArrayList;

public class SmallPallet {
    private Product product;
    private int quantity;
    private boolean toStore;

    public SmallPallet(Product p, int q, boolean store){
        this.product = p;
        this.quantity = q;
        this.toStore = store;
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
