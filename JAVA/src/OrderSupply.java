import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderSupply {

	private ArrayList<SmallPallet> palletsForDeparture;
	private HashMap<Product, Integer> productsFromDatabase;

	public OrderSupply() {
		this.productsFromDatabase = new HashMap<Product, Integer>();
	}

	public void newOrder(int id, String name, String type, int quantity) throws RemoteException {
		System.out.println("The product " + name + " has been added to the order");
		productsFromDatabase.put((new Product(id, name, type)), quantity);

	}

	public ArrayList<SmallPallet> getPalletsForConveyorBet() {
		palletsForDeparture = new ArrayList<SmallPallet>();

		for (HashMap.Entry<Product, Integer> entry : productsFromDatabase.entrySet()) {

			Product prod = entry.getKey();
			Integer quantity = entry.getValue();
			SmallPallet smallPallet = new SmallPallet(prod.getId(), prod, quantity, true);
			palletsForDeparture.add(smallPallet);
			System.out.println("Created pallet for departure with product id: " + prod.getId() + " and quantity: " + quantity);
		}
		return palletsForDeparture;
	}
	
	public void resetHashMapofProductsForDeparture(){
		productsFromDatabase.clear();
	}

	public HashMap<Product, Integer> getProducts() {
		return productsFromDatabase;
	}

}
