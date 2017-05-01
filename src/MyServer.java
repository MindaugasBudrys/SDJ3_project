import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.net.*;
import java.net.UnknownHostException;

public class MyServer extends java.rmi.server.UnicastRemoteObject implements RMIInterface {
	String address;
	Registry registry;


	public MyServer() throws RemoteException {
		try {
			address = (InetAddress.getLocalHost()).toString();
		} catch (Exception e) {
			System.out.println("can't get inet address.");
		}
		int port = 3232;
		System.out.println("this address=" + address + ",port=" + port);
		try {
			registry = LocateRegistry.createRegistry(port);
			registry.rebind("rmiServer", this);
		} catch (RemoteException e) {
			System.out.println("remote exception" + e);
		}
	}

	static public void main(String args[]) throws UnknownHostException {
		
		System.out.println("Hello, server test ip is: " + InetAddress.getLocalHost().toString());
		
		
		try {
			MyServer server = new MyServer();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void orderNewGoods(String example) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendGoods(String example) throws RemoteException {
		System.out.println(example);
	}
}