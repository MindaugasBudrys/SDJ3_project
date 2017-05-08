import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface iWarehouseControl extends Remote{
	
	public void orderNewProducts(ArrayList<String> hashmap) throws RemoteException;
	public void orderProductsForDeparture(String example) throws RemoteException;
	public void sendNewProductsToConveyarBelt() throws RemoteException;
	public void storeToShelf() throws RemoteException;
	public void createAnOrder() throws RemoteException;
}
