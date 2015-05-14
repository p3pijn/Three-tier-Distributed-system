package tier3.db;

import java.io.*;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class ServerCORBA
{
   private ORB theOrb;
   private POA thePoa;

   public ServerCORBA(String[] args)
   {
      try
      { // init ORB
         theOrb = ORB.init(args, null);
         // init POA
         thePoa = POAHelper
               .narrow(theOrb.resolve_initial_references("RootPOA"));
         thePoa.the_POAManager().activate();
         // init file
         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public void attach(Servant theServantObj, String filename)
   {
      try (PrintWriter pw = new PrintWriter(new FileWriter(filename));)
      { // create the object reference
         org.omg.CORBA.Object obj = thePoa.servant_to_reference(theServantObj);
         // print stringified object reference to file
         pw.println(theOrb.object_to_string(obj));
         pw.flush();
         System.out.println("stringified object reference to file " + filename);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public void run()
   {
      System.out.println("server is ready ...");
      // wait for requests
      theOrb.run();
   }
   
}