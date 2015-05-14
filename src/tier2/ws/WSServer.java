package tier2.ws;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WSServer extends Remote
{
   /**
    * How many items with given id are stored in the warehouse
    * @param id the id of the items
    * @return the number of the items
    * @throws RemoteException
    */
   int howManyItemsId(int id) throws RemoteException;
   
   int howManyItemsLocation(String location) throws RemoteException;
   
   int palletsStoredSinceStart() throws RemoteException;
   
   /**
    * Total number of all items in the warehouse
    * @return number of all items
    * @throws RemoteException
    */
   int totalItems() throws RemoteException;
   
   /**
    * Total number of places occupied by pallets in the warehouse
    * @return 
    * @throws RemoteException
    */
   int placesOccupied() throws RemoteException;
}
