import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface iWarehouseControl extends Remote{
	
	public void orderNewProducts(ArrayList<String> listOfProductsForWarehouse) throws RemoteException;
	public void orderProductsForDeparture(ArrayList<String> listOfProductsForDeparture) throws RemoteException;
	public void storeToShelf() throws RemoteException;
}
