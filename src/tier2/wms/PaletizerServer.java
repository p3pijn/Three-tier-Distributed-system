package tier2.wms;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Pallet;

public interface PaletizerServer extends Remote
{
   /**
    * Stores a pallet in the warehouse
    * @param p the pallet to be stored
    * @throws RemoteException
    */
   void storePallet(Pallet p) throws RemoteException;
}
