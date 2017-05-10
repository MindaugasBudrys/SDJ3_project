import java.util.HashMap;

public class DepartureStation {

	//private HashMap<Product, Integer> productsForDeparture;
	
	public DepartureStation(){
		
	}
	
	public void loadToTruck(HashMap<Product, Integer> productsForDeparture){
		
        for (HashMap.Entry<Product, Integer> entry : productsForDeparture.entrySet()) {
            Product prod = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println("Loaded to the truck: " + quantity + "of product: " + prod.getId());
        }
		System.out.println("Your order has been sent!");
	}
}
