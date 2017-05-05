import java.util.ArrayList;

public class SmallPallet {
    private Product product;
    private int quantity;

    public SmallPallet(Product p, int q){
        this.product = p;
        this.quantity = q;
    }

    public Product getProduct(){
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
