import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote{
	
	public void orderNewGoods(String example) throws RemoteException;
	public void sendGoods(String example) throws RemoteException;
	
	
}
