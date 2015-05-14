package tier2.wms;

import java.rmi.RemoteException;

import tier3.crane.ICrane;
import tier3.db.corba.ItemDatabaseOperations;
import model.Pallet;

/**
 * Thread that is storing a pallet in the warehouse.
 */
public class StoreThread extends Thread {

	private Pallet p;
	private ItemDatabaseOperations db;
	private ICrane crane;
   private static int palletsAdded = 0;
	
/**
 * 
 * @param p - the pallet 
 * @param db - the database where to store the location of the pallet in the crane
 * @param crane - the crane where to store the pallet
 */
	public StoreThread(Pallet p, ItemDatabaseOperations db, ICrane crane)
	{
		this.p = p;
		this.db = db;
		this.crane = crane;
	}
	
/**
 * the method is saving the pallet in the crane 
 * the crane returns the location where you can find the items
 * in the end, the id of the items, the amount of them and the location where they
 * can be found in the crane is stored in the database
 * if this fails, pallet is retrieved from the crane
 */
	@Override
	public void run() {
		int amount = p.getAmount();
		if(amount == 0)
			return;
		String location = null;
		boolean success = false;
		try {
			location = crane.storePallet(p);
			int id = p.next().id; // throws away one item but the pallet is alredy written in a file and so its ok (we also have to remember the amount before)
			try {
			   success = db.stored(id, amount, location);
			} catch (Exception e) {
			   e.printStackTrace();
			}
			if(success)
			   incCounter();
			else
			   crane.retrievePallets(new String[]{location});
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

   private static synchronized void incCounter()
   {
      palletsAdded++;
   }
   
   public static synchronized int getCounter()
   {
      return palletsAdded;
   }
}
