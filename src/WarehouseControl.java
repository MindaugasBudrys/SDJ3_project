import java.io.Serializable;
import java.rmi.RemoteException;

public class WarehouseControl implements Interface, Serializable {

    @Override
    public void orderNewGoods(String example) throws RemoteException {
    System.out.println(example);
    }

    @Override
    public void sendGoods(String example) throws RemoteException {

    }
}
