import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderSupply {

	private ArrayList<SmallPallet> palletsForDeparture;
	private HashMap<Product, Integer> productsFromDatabase;
	
	private Model model;
	private String name;
	private String type;

	public OrderSupply() throws Exception {
		this.productsFromDatabase = new HashMap<Product, Integer>();
		this.model = new Model();
	}

	public void newOrder(int id, int quantity) throws Exception {
		splitString(model.getRowByIDFromDatabase(id));
    	System.out.println("Product "+ id + " " + name +" has been sent to departure");
		productsFromDatabase.put((new Product(id, name, type)), quantity);

	}
	
    private void splitString(String string){
        String[] token = string.split(",");
        name = token[1];
        type = token[2];
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
