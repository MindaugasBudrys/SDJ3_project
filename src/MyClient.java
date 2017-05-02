import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class MyClient {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", (new Integer(1159)).intValue());
		Interface inter = (Interface) (registry.lookup("Warehouse_server"));
		View view = new View();
		Controller controller = new Controller(view, inter);
		controller.menu();
	}
}