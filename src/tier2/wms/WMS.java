package tier2.wms;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Pallet;
import tier1.pick.PickClient;
import tier2.wms.dba.CorbaDBA;
import tier2.ws.WSServer;
import tier3.crane.ICrane;
import tier3.db.corba.ItemDatabaseOperations;

/**
 *  Class that is connecting the database, the crane and also the statistics web server.
 *  Depending on the choice, it can either store the items in the crane, or it can pick the items from the crane for a specific client
 */
public class WMS extends UnicastRemoteObject implements PaletizerServer, PickServer, WSServer{


	private static final long serialVersionUID = -7773963480947090024L;

	private ItemDatabaseOperations database;
	private ICrane crane;

	
	public WMS(String rmiCrane, String corbaDB) throws NotBoundException, IOException
	{
		super();
		database=CorbaDBA.getDB(corbaDB);
		crane = (ICrane) Naming.lookup(rmiCrane);
	}
	
	/**
	 * method that return how many items of a specific id are found in the database
	 */
	 @Override
	 public int howManyItemsId(int id) throws RemoteException
	 {
	    return database.countItems(id, "");
	 }
	 
	/**
	 * method that return how many items are found in the database
	 */
	 @Override
	 public int totalItems() throws RemoteException
	 {
	    return database.countItems(-1, "");
	 }
	 
	 @Override
	 public int howManyItemsLocation(String location) throws RemoteException
	 {
	    return database.countItems(-1, location);
	 }
	
   /**
   * method that return how many locations are used in the database
   */
	@Override
	public int placesOccupied() throws RemoteException 
	{
		return crane.placesOccupied();
	}
   	

   @Override
   public int palletsStoredSinceStart() throws RemoteException
   {
      return StoreThread.getCounter();
   }
   
   /**
    * method that is picking specific items, by starting the PickThread thread
    * @see PickThread
    */
	@Override
	public void askItems(int id, int amount, PickClient caller)
			throws RemoteException {
		new PickThread(caller, id, amount, database, crane).start();
	}

   /**
   * method that is storing specific pallet in the crane, by starting the StoreThread thread
   * @see StoreThread
   */

	@Override
	public void storePallet(Pallet p) throws RemoteException {
		new StoreThread(p, database, crane).start();
	}

}
