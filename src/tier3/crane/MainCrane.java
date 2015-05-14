package tier3.crane;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 * The main class for starting the crane server. It is using RMI.
 */
public class MainCrane {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1098);
		Naming.rebind("//localhost:1098/crane", new Crane("warehouse\\"));
	}

}
