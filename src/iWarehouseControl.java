import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iWarehouseControl extends Remote{
	
	public void orderNewProducts(int id, String name, String type, int quantity) throws RemoteException;
	public void sendGoods(String example) throws RemoteException;
	public void sendNewProductsToConveyarBelt() throws RemoteException;
	public void storeToShelf() throws RemoteException;
	public void createAnOrder() throws RemoteException;
}
