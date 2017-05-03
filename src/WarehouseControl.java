import java.io.Serializable;
import java.rmi.RemoteException;

public class WarehouseControl implements Interface, Serializable {
    ProductSupply supply;

    public WarehouseControl(){
        supply = new ProductSupply();
    }
    @Override
    public void orderNewGoods(int id, int quantity) throws RemoteException {
        //supply.newProduct(id, quantity);
    }

    @Override
    public void sendGoods(String example) throws RemoteException {
        System.out.println(example);
    }
    
}
