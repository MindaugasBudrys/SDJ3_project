import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iWarehouseControl extends Remote{
	
	public void orderNewProducts(int id, String name, String type, int quantity) throws RemoteException;
	public void sendGoods(String example) throws RemoteException;
	public void rearrangeProducts() throws RemoteException;
	
}
