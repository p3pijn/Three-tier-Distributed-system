package tier1.webclient;

import java.rmi.RemoteException;
import java.util.Scanner;

import tier1.webclient.stub.*;
import tier1.webclient.stub.WSServerStub.*;
/**
 * The main class for starting the client displaying the statistics. It is using web services.
 */
public class MainWebClient
{

   public static void main(String[] args) throws RemoteException,
         WSServerRemoteExceptionException
   {
      WSServerStub stub = new WSServerStub();

      Scanner key = new Scanner(System.in);
      System.out.println("1: Total Items");
      System.out.println("2: How Many Items Id");
      System.out.println("3: How Many Items Location");
      System.out.println("4: Places Occupied");
      System.out.println("5: Pallets Stored Since Start");
      System.out.println("-1: Exit");
      int choice = key.nextInt();

      while (choice != -1)
      {

         switch (choice)
         {

            case 1:
            {
               System.out.println(stub.totalItems(new TotalItems())
                     .get_return());
               break;
            }

            case 2:
            {
               HowManyItemsId arg = new HowManyItemsId();
               arg.setArgs0(key.nextInt());
               System.out.println(stub.howManyItemsId(arg).get_return());
               break;
            }

            case 3:
            {
               HowManyItemsLocation arg = new HowManyItemsLocation();
               key.nextLine();
               arg.setArgs0(key.nextLine());
               System.out.println(stub.howManyItemsLocation(arg).get_return());
               break;
            }

            case 4:
            {
               System.out.println(stub.placesOccupied(new PlacesOccupied())
                     .get_return());
            }
            
            case 5:
            {
               System.out.println(stub.palletsStoredSinceStart(new PalletsStoredSinceStart()).get_return());
            }
         }

         System.out.println("1: Total Items");
         System.out.println("2: How Many Items Id");
         System.out.println("3: How Many Items Location");
         System.out.println("4: Places Occupied");
         System.out.println("5: Pallets Stored Since Start");
         System.out.println("-1: Exit");
         choice = key.nextInt();
      }
      
      key.close();
   }
   
}