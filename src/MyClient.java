import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class MyClient {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		//RMI Client
		Registry registry = LocateRegistry.getRegistry("localhost", (new Integer(1159)).intValue());
		iWarehouseControl inter = (iWarehouseControl) (registry.lookup("Warehouse_server"));
		
		
		View view = new View();
		Controller controller = null;
		try {
			controller = new Controller(view, inter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		controller.menu();
	}
}