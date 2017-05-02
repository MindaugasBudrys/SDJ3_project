import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		System.out.println("Hi lol 2nd mainserv");
		WarehouseControl warehouseControl = new WarehouseControl();
		Interface rmiInterface = (Interface)UnicastRemoteObject.exportObject(warehouseControl, 0);
		Registry registry = LocateRegistry.createRegistry(1159);
		registry.bind("Warehouse_server", rmiInterface);
	}
}