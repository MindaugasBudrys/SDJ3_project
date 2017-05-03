import java.io.Serializable;
import java.rmi.RemoteException;

public class WarehouseControl implements Interface, Serializable {
    ProductSupply supply;

    public WarehouseControl(){
        supply = new ProductSupply();
    }
    @Override
    public void orderNewGoods(String type, String name, int id, int quantity) throws RemoteException {
        supply.newProduct(type, name, id, quantity);
    }

    @Override
    public void sendGoods(String example) throws RemoteException {
        System.out.println(example);
    }
}
