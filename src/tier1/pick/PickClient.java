package tier1.pick;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Pallet;

public interface PickClient extends Remote
{
   /**
    * Callback method called by the server after it retrieves the items
    * requested by the client.
    * @param pallets pallets containing requested items
    * @throws RemoteException
    */
   void givePallets(Pallet[] pallets) throws RemoteException;
}
