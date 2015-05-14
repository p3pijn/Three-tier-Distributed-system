package tier2.wms.dba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;

import tier3.db.corba.ItemDatabaseHelper;
import tier3.db.corba.ItemDatabaseOperations;

public class CorbaDBA// implements ItemDatabaseOperations
{
   /*
   ItemDatabase db;
   
   public CorbaDBA(String reference)
   {
      ORB theOrb = ORB.init(new String[0], null);
      org.omg.CORBA.Object obj = null;
      try (BufferedReader br = new BufferedReader(new FileReader(new File(reference)));)
      { // get object reference from command-line argument file
         obj = theOrb.string_to_object(br.readLine());
         br.close();
         db = ItemDatabaseHelper.narrow(obj);
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public String[] getLocations(int id, int amount)
   {
      return db.getLocations(id, amount);
   }

   @Override
   public void stored(int id, int amount, String location)
   {
      db.stored(id, amount, location);
   }*/
   
   public static ItemDatabaseOperations getDB(String reference) throws IOException
   {
      ORB theOrb = ORB.init(new String[]{}, null);
      org.omg.CORBA.Object obj = null;
      BufferedReader br = new BufferedReader(new FileReader(new File(reference)));
      // get object reference from command-line argument file
      obj = theOrb.string_to_object(br.readLine());
      try{
         br.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return ItemDatabaseHelper.narrow(obj);
   }

}
