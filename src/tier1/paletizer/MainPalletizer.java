package tier1.paletizer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import model.Item;
import model.Pallet;
import tier2.wms.PaletizerServer;
/**
 * The main class for starting the palletizer server. The details about items and the amount
 *  are typed from the keyboard. The request to store the items is sent to wms server.
 */
public class MainPalletizer {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		PaletizerServer wms = (PaletizerServer) Naming.lookup("rmi://localhost:1099/wms");

		Scanner key = new Scanner(System.in);
		Pallet p;
		
		System.out.println("palletizer, enter -1 to exit");
		int exit = key.nextInt();
		while(exit != -1)
		{
			System.out.println("enter id, name, description, weight, volume, amount");
			int id = key.nextInt();
			key.nextLine();
			Item i = new Item(id, key.nextLine(), key.nextLine(), key.nextInt(), key.nextInt());
			int amount = key.nextInt();
			while(amount > 0)
			{
				p = new Pallet();
				while(amount > 0 && p.add(i))
					amount--;
				wms.storePallet(p);
				System.out.println(p.getAmount() + " items stored.");
			}
			System.out.println("enter -1 to exit");
			exit = key.nextInt();
		}
		key.close();
	}

}
