package tier2.wms;

import java.rmi.Remote;
import java.rmi.RemoteException;

import tier1.pick.PickClient;

public interface PickServer extends Remote
{
   /**
    * called by a client to request items. This is asynchronous
    * method that starts retrieving of the items. After the retrieving is done
    * the server makes a callback to give requested items to the client.
    * @see PickClient#givePallets(model.Pallet[])
    * @param id id of the items requested
    * @param amount amount of the items requested
    * @param caller the client that requests the items
    * @throws RemoteException
    */
   void askItems(int id, int amount, PickClient caller) throws RemoteException;
}
