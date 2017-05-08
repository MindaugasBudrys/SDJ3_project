import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;

public class WarehouseControl implements iWarehouseControl, Serializable {
    private ProductSupply supply;
    private ArrivalStation arrivalStation;
    private ConveyorBelt conveyorBelt;
    private Crane crane;
    private PickStation pickStation;

    public WarehouseControl() throws Exception{
        arrivalStation = new ArrivalStation();
        supply = new ProductSupply();
        conveyorBelt = new ConveyorBelt();
        crane = new Crane();
        pickStation = new PickStation();
    }
    @Override
    public void orderNewProducts(HashMap<Integer, Integer> newProducts) throws RemoteException {
        try {
        	int id = 0;
        	string name = "";
        	string type = "";
        	
        	for (int i = 0; i < newProducts.size(); i++) {
        		
        	}
            supply.newProduct(id, quantity);
            arrivalStation.rearrangeProducts(supply.getProducts());//Rearrange products in to small pallets
            conveyorBelt.addNewPallets(arrivalStation.getPallets());
            storeToShelf();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
        int pallet_id = 3;//What is that value? NEEDS TO BE CHANGED ALL THE TIMES
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
