import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ArrivalStation implements Serializable{
    private ArrayList<SmallPallet> pallets;
    private HashMap<Product, Integer> listOfProducts;
    public ArrivalStation(){

    }
    public void rearrangeProducts(HashMap<Product, Integer> p){
        this.listOfProducts = p;
        pallets = new ArrayList<SmallPallet>();

        for (HashMap.Entry<Product, Integer> entry : listOfProducts.entrySet()) {
            Product prod = entry.getKey();
            Integer integer = entry.getValue();
            SmallPallet smallPallet = new SmallPallet(prod, integer);
            pallets.add(smallPallet);
            System.out.println(prod.getId() + " " + integer);
        }

    }
}
