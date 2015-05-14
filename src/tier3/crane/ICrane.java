package tier3.crane;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Pallet;

public interface ICrane extends Remote
{
   /**
    * Stores a pallet in the warehouse and returns its location
    * @param p the pallet to be stored
    * @return location of the pallet stored
    * @throws RemoteException
    */
   String storePallet(Pallet p) throws RemoteException;
   
   /**
    * Retrieves pallets from specified locations
    * @param locations locations of the pallets
    * @return pallets retrieved
    * @throws RemoteException
    */
   Pallet[] retrievePallets(String[] locations) throws RemoteException;
   /**
    * Method that returns the number of the pallets that exists in the database.
    */
   int placesOccupied() throws RemoteException;
}
