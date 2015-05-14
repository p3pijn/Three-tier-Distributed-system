package mains;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;

import tier2.wms.WMS;
/**
 * The main class for starting the warehouse management server. It is using RMI.
 */
public class MainWMS {

	public static void main(String[] args) throws NotBoundException, IOException {
		LocateRegistry.createRegistry(1099); // wms on 1099
		Naming.rebind("//localhost:1099/wms", new WMS("rmi://localhost:1098/crane", "Legacy database reference")); // crane on 1098
	}

}
