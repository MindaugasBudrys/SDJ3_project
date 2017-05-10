import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, Exception {
		System.out.println("Server is working...");
		WarehouseControl warehouseControl = new WarehouseControl();
		iWarehouseControl rmiIWarehouseControl = (iWarehouseControl)UnicastRemoteObject.exportObject(warehouseControl, 0);
		Registry registry = LocateRegistry.createRegistry(1159);
		registry.bind("Warehouse_server", rmiIWarehouseControl);
	}
}