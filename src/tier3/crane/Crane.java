package tier3.crane;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tier3.crane.io.FileIO;
import model.Pallet;
/**
 * Class that is storing the pallets in a file, and it is retrieving them from the files.
 * @author Marya
 *
 */
public class Crane extends UnicastRemoteObject implements ICrane{

	private static final long serialVersionUID = 3438477882448877045L;
	
	private final String path;
	private static final int LENGTH=10;
	/**
	 * Constructor that is creating a directory in the path that is specified as an argument.
	 * @param path
	 * @throws RemoteException
	 */
	public Crane(String path) throws RemoteException
	{
		super();
		this.path = path;
		FileIO.createDir(path);
	}
	/**
	 * Synchronized method that is creating a random file name and is saving the specified pallet in the file.
	 * Method returns the name of the file.
	 */
	@Override
	public synchronized String storePallet(Pallet p) throws RemoteException
	{
		String fileName = FileIO.nextFileName(LENGTH, path);
		FileIO.write(path + fileName, p);
		return fileName;
	}
	/**
	 * Synchronized method that is retrieving an array of pallets from the specified locations (files).
	 * Method returns the array of pallets found. In the case there is no pallet, an empty one will be returned.
	 */
	@Override
	public Pallet[] retrievePallets(String[] locations) throws RemoteException 
	{	
		Pallet[] p = new Pallet[locations.length];
		for(int i=0;i<locations.length;i++)
		{
			p[i] = (Pallet) FileIO.readDelete(path + locations[i]);
			if(p[i] == null)
				p[i] = Pallet.EMPTY;
		}
		return p;
	}
    /**
     * Method that returns the number of the pallets that exists in the database.
     */
	@Override
	public int placesOccupied() throws RemoteException {
		return FileIO.countFiles(path);
	}

}
