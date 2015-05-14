package mains;

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
		
		System.out.println("Palletizer, enter -1 to exit");
		System.out.println( "If you want to store, enter any positive number");
		int exit = key.nextInt();
		
		while(exit != -1)
		{
			System.out.println("enter id of the item");
			int id = key.nextInt();
			System.out.println("enter the name of the item");
			key.nextLine();
			String name=key.nextLine();
			
			System.out.println("enter the description of the item");
			String description=key.nextLine();
			System.out.println("enter the weight of the item");
			int weight=key.nextInt();
			System.out.println("enter the volume of the item");
			int volume=key.nextInt();
			
			Item i = new Item(id, name, description, weight, volume);
			
			System.out.println("enter the amount of the item");
			int amount=key.nextInt();
			while(amount > 0)
			{
				p = new Pallet();
				while(amount > 0 && p.add(i))
					amount--;
				wms.storePallet(p);
				System.out.println(p.getAmount() + " items stored.");
			}
			System.out.println("enter -1 to exit");
			System.out.println( "If you want to keep on storing, enter any positive number");
			exit = key.nextInt();
		}
		key.close();
	}

}
