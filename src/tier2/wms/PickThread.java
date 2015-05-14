package tier2.wms;

import java.rmi.RemoteException;

import model.Pallet;
import tier1.pick.PickClient;
import tier3.crane.ICrane;
import tier3.db.corba.ItemDatabaseOperations;

public class PickThread extends Thread {
 /**
  * Thread used for picking a specific amount of specific items. 
  * These items are found in the crane, in a specific location, that is saved in the database
  */

	private PickClient client;
	private int id;
	private int amount;
	private ItemDatabaseOperations db;
	private ICrane crane;
	
	/**
	 * 
	 * @param client - the client that requires the items
	 * @param id - the id of the items
	 * @param amount - how many items of the specified id are needed
	 * @param db - the database from where we get the location
	 * @param crane - the crane where are the pallets
	 */
	public PickThread(PickClient client, int id, int amount, ItemDatabaseOperations db, ICrane crane) {
		super("PickThread");
		this.client = client;
		this.id = id;
		this.amount = amount;
		this.db = db;
		this.crane = crane;
	}
	/**
	 * we create an array in witch we keep the location where the items are found in the crane
	 * we retrieve the pallets that are found in these locations , in an array of pallets  
	 * we found out the exactly necessary amount of items we need from the crane
	 * in case we have more items than needed, another thread is started and the unused items will be 
	 * saved in another pallet. In the end, the right amount of items is given to the client 
	 */
	@Override
	public void run() {
		String[] locations = db.getLocations(id, amount);
		try {
			Pallet[] pallets = crane.retrievePallets(locations);
			int sumAmount = 0;
			for(int i=0;i<pallets.length;i++)
			{
				sumAmount+=pallets[i].getAmount();
			}
			
			if(sumAmount > amount)
			{
				Pallet rest=new Pallet();
				
				for(int i=sumAmount; i>amount;i--)
				{
					rest.add(pallets[pallets.length-1].next());
				}
				new StoreThread(rest, db, crane).start();
			}
			client.givePallets(pallets);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
