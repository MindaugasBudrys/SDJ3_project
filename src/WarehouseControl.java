import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseControl implements iWarehouseControl, Serializable {
    private ProductSupply productSupply;
    private OrderSupply orderSupply;
    private ArrivalStation arrivalStation;
    private ConveyorBelt conveyorBelt;
    private Crane crane;
    private PickStation pickStation;
    private DepartureStation departureStation;

    
    private int product_id;
    private String name;
    private String type;
    private int quantity;
    
    public WarehouseControl() throws Exception{
        arrivalStation = new ArrivalStation();
        productSupply = new ProductSupply();
        orderSupply = new OrderSupply();
        conveyorBelt = new ConveyorBelt();
        crane = new Crane();
        pickStation = new PickStation();
        departureStation = new DepartureStation();
    }
    @Override
    public void orderNewProducts(ArrayList<String> newProducts) throws RemoteException {
        try {
        	
        	for (int i = 0; i < newProducts.size(); i++) {
        		splitString(newProducts.get(i));
        	    System.out.println(product_id + "/" + name);
        	    productSupply.newProduct(product_id, name, type, quantity);
        	}

        	System.out.println("HashMap of products: ");
        	for (HashMap.Entry<Product, Integer> entry : productSupply.getProducts().entrySet()) {
                Product prod = entry.getKey();
                Integer integer = entry.getValue();
                System.out.println("PRODUCT FOR WAREHOUSE: " + prod.getId() + " " + integer);
            }

            arrivalStation.rearrangeProducts(productSupply.getProducts());//Rearrange products in to small pallets
            
            conveyorBelt.addNewPallets(arrivalStation.getPallets());
            
            System.out.println("Pallets in conveyor belt: " + conveyorBelt.getPallets().size());
            int totalNumPallets = conveyorBelt.getPallets().size();
            for( int i = 0; i < totalNumPallets ; i++) {
                storeToShelf();
            }

            //Clearing HashMap for later orders - Otherwise it takes the last order as well
            productSupply.resetHashMapOfProducts();
            //Clearing ArrayList for later orders - Otherwise it takes the last order as well
            arrivalStation.resetArrayListOfPallets();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
    public void splitString(String string){

        String[] token = string.split(",");
        product_id = Integer.parseInt(token[0]);
        name = token[1];
        type = token[2];
        quantity = Integer.parseInt(token[3]);

    System.out.println(product_id + "/" + name + "/" + type);
    }

    @Override
    public void orderProductsForDeparture(ArrayList<String> newProductsForDeparture) throws RemoteException {
    	for (int i = 0; i < newProductsForDeparture.size(); i++) {
    		splitString(newProductsForDeparture.get(i));
    	    System.out.println(product_id + "/" + name);
    	    orderSupply.newOrder(product_id, name, type, quantity);
    	}
    	
    	for (HashMap.Entry<Product, Integer> entry1 : orderSupply.getProducts().entrySet()) {
            Product prod = entry1.getKey();
            Integer quantity = entry1.getValue();
            System.out.println("PRODUCT FOR DEPARTURE: " + prod.getId() + " " + quantity);
            
            getFromShelf(prod.getId(), quantity);
        }
    	
    	conveyorBelt.addNewPallets(orderSupply.getPalletsForConveyorBet());
    	pickStation.addToOrder(conveyorBelt.getPallets());
    	departureStation.loadToTruck(pickStation.getOrder());
    	
        //Clearing HashMap for later orders - Otherwise it takes the last order as well
        orderSupply.resetHashMapofProductsForDeparture();
        //Clearing ArrayList for later orders - Otherwise it takes the last order as well
        pickStation.resetHashMapOfProductsForDeparture();
    }
    
    
    private void getFromShelf(int p_id, int quant) {
    	crane.getFromDatabase(p_id, quant);
	}
    
    
    @Override
    public void storeToShelf() throws RemoteException{

        SmallPallet pallet = conveyorBelt.getToShelf();
        int pallet_id = pallet.getId();
        int product_id = pallet.getProduct().getId();
        int shelf_id = 0;//What is that value?
        int quantity = pallet.getQuantity();

        System.out.println("Storing pallet: " + pallet.getId());
        crane.storeToDatabase(pallet_id, product_id, shelf_id, quantity);
    }

//  @Override
//  public void rearrangeProducts() throws RemoteException {
//      arrivalStation.rearrangeProducts(supply.getProducts());
//  }

}
