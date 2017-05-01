import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
import java.net.UnknownHostException;

public class MyClient {
	static public void main(String args[]) throws UnknownHostException {
		//System.out.println("Hello, client test ip is: " + InetAddress.getLocalHost().toString());
		
		
		
		RMIInterface rmiServer;
		Registry registry;
		String serverAddress = "localhost";
		String serverPort = "3232";
		String text = "hello123";
		System.out.println("sending " + text + " to " + serverAddress + ":" + serverPort);
		try {
			registry = LocateRegistry.getRegistry(serverAddress, (new Integer(serverPort)).intValue());
			rmiServer = (RMIInterface) (registry.lookup("rmiServer"));
			// call the remote method
			rmiServer.sendGoods(text);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.err.println(e);
		}
	}
}