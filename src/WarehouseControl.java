import java.io.Serializable;
import java.rmi.RemoteException;

public class WarehouseControl implements iWarehouseControl, Serializable {
    private ProductSupply supply;
    private ArrivalStation arrivalStation;

    public WarehouseControl(){
        arrivalStation = new ArrivalStation();
        supply = new ProductSupply();
    }
    @Override
    public void orderNewProducts(int id, String name, String type,  int quantity) throws RemoteException {
        try {
            supply.newProduct(id, name, type, quantity);
            arrivalStation.rearrangeProducts(supply.getProducts());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendGoods(String example) throws RemoteException {
        System.out.println(example);
    }

    @Override
    public void rearrangeProducts() throws RemoteException {

    }

}
