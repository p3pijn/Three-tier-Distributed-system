package mains;

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
               System.out.println("there are "+ stub.totalItems(new TotalItems())
                     .get_return()+ " items ");
               break;
            }

            case 2:
            {
               HowManyItemsId arg = new HowManyItemsId();
               System.out.println("enter the id of the item");
               arg.setArgs0(key.nextInt());
               System.out.println("there are "+stub.howManyItemsId(arg).get_return()+ " items with this id");
               break;
            }

            case 3:
            {
               HowManyItemsLocation arg = new HowManyItemsLocation();
               System.out.println("enter the location of the item");
               key.nextLine();
               arg.setArgs0(key.nextLine());
               System.out.println("there are "+stub.howManyItemsLocation(arg).get_return()+ " items in this location");
               break;
            }

            case 4:
            {
               System.out.println("there is a number of "+stub.placesOccupied(new PlacesOccupied())
                     .get_return()+ " occupied places");
               break;
            }
            
            case 5:
            {
               System.out.println("there are "+stub.palletsStoredSinceStart(new PalletsStoredSinceStart()).get_return()+ " pallets stored since WMS started");
               break;
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