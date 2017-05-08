import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseControl implements iWarehouseControl, Serializable {
    private ProductSupply supply;
    private ArrivalStation arrivalStation;
    private ConveyorBelt conveyorBelt;
    private Crane crane;
    private PickStation pickStation;

    
    private int product_id;
    private String name;
    private String type;
    private int quantity;
    
    public WarehouseControl() throws Exception{
        arrivalStation = new ArrivalStation();
        supply = new ProductSupply();
        conveyorBelt = new ConveyorBelt();
        crane = new Crane();
        pickStation = new PickStation();
    }
    @Override
    public void orderNewProducts(ArrayList<String> newProducts) throws RemoteException {
        try {
        	
        	for (int i = 0; i < newProducts.size(); i++) {
        		splitString(newProducts.get(i));
        	    System.out.println(product_id + "/" + name);
        	    supply.newProduct(product_id, name, type, quantity);
        	}

        	System.out.println("HashMap of products: ");
        	for (HashMap.Entry<Product, Integer> entry : supply.getProducts().entrySet()) {
                Product prod = entry.getKey();
                Integer integer = entry.getValue();
                System.out.println("HELLO: " + prod.getId() + " " + integer);
            }

            arrivalStation.rearrangeProducts(supply.getProducts());//Rearrange products in to small pallets
            conveyorBelt.addNewPallets(arrivalStation.getPallets());
            for( int i = 0; i < conveyorBelt.getPallets().size(); i++) {
                storeToShelf();
                System.out.println("HELLOOOOOOO1");
            }
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
    public void orderProductsForDeparture(String example) throws RemoteException {
    	
    }
    
    
    @Override
    public void sendNewProductsToConveyarBelt() throws RemoteException{
        conveyorBelt.addNewPallets(arrivalStation.getPallets());
    }
    
    @Override
    public void storeToShelf() throws RemoteException{

        SmallPallet pallet = conveyorBelt.getToShelf();
        int pallet_id = pallet.getId();
        int product_id = pallet.getProduct().getId();
        int shelf_id = 0;//What is that value?
        int quantity = pallet.getQuantity();

        crane.storeToDatabase(pallet_id, product_id, shelf_id, quantity);
    }
    
    @Override
    public void createAnOrder(){

    }
//    @Override
//    public void rearrangeProducts() throws RemoteException {
//        arrivalStation.rearrangeProducts(supply.getProducts());
//    }

}
