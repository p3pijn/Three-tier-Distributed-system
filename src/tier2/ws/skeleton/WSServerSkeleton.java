/**
 * WSServerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package tier2.ws.skeleton;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import tier2.ws.*;

/**
 * WSServerSkeleton java skeleton for the axisService
 */
public class WSServerSkeleton implements WSServerSkeletonInterface {

	/**
	 * Returns how many items with the specific id are found in the database.
	 * 
	 * @param howManyItemsId0 
	 * @return howManyItemsIdResponse1 - the result 
	 * @throws WSServerRemoteExceptionException
	 */

	public tier2.ws.HowManyItemsIdResponse howManyItemsId(
			tier2.ws.HowManyItemsId howManyItemsId0)
			throws WSServerRemoteExceptionException {
		HowManyItemsIdResponse res = new HowManyItemsIdResponse();
		try {
			WSServer wms = (WSServer) Naming.lookup("rmi://localhost:1099/wms");
			res.set_return(wms.howManyItemsId(howManyItemsId0.getArgs0()));
			return res;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new WSServerRemoteExceptionException(
					"error occured, check web server for stack trace");
		}
	}

	/**
	 * Returns how many items are in the database.
	 * 
	 * @param totalItems2
	 * @return totalItemsResponse3
	 * @throws WSServerRemoteExceptionException
	 */

	public tier2.ws.TotalItemsResponse totalItems(
			tier2.ws.TotalItems totalItems2)
			throws WSServerRemoteExceptionException {
		TotalItemsResponse res = new TotalItemsResponse();
		try {
			WSServer wms = (WSServer) Naming.lookup("rmi://localhost:1099/wms");
			res.set_return(wms.totalItems());
			return res;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new WSServerRemoteExceptionException(
					"error occured, check web server for stack trace");
		}
	}

	/**
	 * Returns how many pallets are in the warehouse.
	 * 
	 * @param placesOccupied4
	 * @return placesOccupiedResponse5
	 * @throws WSServerRemoteExceptionException
	 */

	public tier2.ws.PlacesOccupiedResponse placesOccupied(
			tier2.ws.PlacesOccupied placesOccupied4)
			throws WSServerRemoteExceptionException {
		PlacesOccupiedResponse res = new PlacesOccupiedResponse();
		try {
			WSServer wms = (WSServer) Naming.lookup("rmi://localhost:1099/wms");
			res.set_return(wms.placesOccupied());
			return res;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new WSServerRemoteExceptionException(
					"error occured, check web server for stack trace");
		}
	}

	/**
	 * Returns how many items are found in the database in a specific location.
	 * 
	 * @param howManyItemsLocation6
	 * @return howManyItemsLocationResponse7
	 * @throws WSServerRemoteExceptionException
	 */

	public tier2.ws.HowManyItemsLocationResponse howManyItemsLocation(
			tier2.ws.HowManyItemsLocation howManyItemsLocation6)
			throws WSServerRemoteExceptionException {
		HowManyItemsLocationResponse res = new HowManyItemsLocationResponse();
		try {
			WSServer wms = (WSServer) Naming.lookup("rmi://localhost:1099/wms");
			res.set_return(wms.howManyItemsLocation(howManyItemsLocation6
					.getArgs0()));
			return res;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new WSServerRemoteExceptionException(
					"error occured, check web server for stack trace");
		}
	}

	/**
	 * Returns how many items were stored in the database since the warehouse management server was started the last time.
	 * 
	 * @param palletsStoredSinceStart8
	 * @return palletsStoredSinceStartResponse9
	 * @throws WSServerRemoteExceptionException
	 */

	public tier2.ws.PalletsStoredSinceStartResponse palletsStoredSinceStart(
			tier2.ws.PalletsStoredSinceStart palletsStoredSinceStart8)
			throws WSServerRemoteExceptionException {
		PalletsStoredSinceStartResponse res = new PalletsStoredSinceStartResponse();
		try {
			WSServer wms = (WSServer) Naming.lookup("rmi://localhost:1099/wms");
			res.set_return(wms.palletsStoredSinceStart());
			return res;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			throw new WSServerRemoteExceptionException(
					"error occured, check web server for stack trace");
		}
	}

}