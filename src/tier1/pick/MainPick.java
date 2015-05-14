package tier1.pick;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Item;
import model.Pallet;
import tier2.wms.PickServer;
/**
 * The main class for starting the pick server. The id of the item and the amount is typed from the keyboard.
 * The request to retrieve them is sent to wms server. In the case it succeeded, the method givePallets from this
 * class will be invoked.
 */
public class MainPick extends UnicastRemoteObject implements PickClient{
	
	private static final long serialVersionUID = -5786191407777208539L;

	public MainPick() throws RemoteException
	{
		super();
	}
	
	public void givePallets(Pallet[] pallets) throws RemoteException 
	{
		System.out.println(pallets.length + " pallets received");
		Map<Integer, Integer> ids = new HashMap<>();
		Map<Integer, Integer> amounts = new HashMap<>();
		for(Pallet p : pallets)
		{
			Integer countA = amounts.get(p.getAmount());
			if(countA == null)
				countA = Integer.valueOf(1);
			else
				countA++;
			amounts.put(p.getAmount(), countA);
			for(Item i : p)
			{
				Integer countID = ids.get(i.id);
				if(countID == null)
					countID = Integer.valueOf(1);
				else
					countID++;
				ids.put(i.id, countID);
			}
		}
		
		for(Entry<Integer, Integer> e : amounts.entrySet())
			System.out.println(e.getValue() + " pallets with " + e.getKey() + " items");
		
		Iterator<Entry<Integer, Integer>> iter = ids.entrySet().iterator();
		while(iter.hasNext())
		{
			Entry<Integer, Integer> e = iter.next();
			System.out.println(e.getValue() + " items with id " + e.getKey());
		}
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		PickServer wms = (PickServer) Naming.lookup("rmi://localhost:1099/wms");
		
		PickClient pc = new MainPick();
		Scanner key = new Scanner(System.in);
		
		System.out.println("pick client, enter -1 to exit");
		int exit = key.nextInt();
		while(exit != -1)
		{
			System.out.println("enter id and amount");
			wms.askItems(key.nextInt(), key.nextInt(), pc);
			System.out.println("enter -1 to exit");
			exit = key.nextInt();
		}
		key.close();
	}

}
