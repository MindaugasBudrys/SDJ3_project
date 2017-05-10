import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.ws.Endpoint;

public class MyServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, Exception {
		System.out.println("Server is working...");
		
		WarehouseControl warehouseControl = new WarehouseControl();
		WebServiceBridge bridge = new WebServiceBridge(warehouseControl);

		Endpoint.publish("http://localhost:9999/ws/warehouse", bridge);
		System.out.println("Web Service Published");
		
		iWarehouseControl rmiIWarehouseControl = (iWarehouseControl)UnicastRemoteObject.exportObject(warehouseControl, 0);
		Registry registry = LocateRegistry.createRegistry(1159);
		registry.bind("Warehouse_server", rmiIWarehouseControl);
	}
}