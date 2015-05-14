package tier3.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import tier3.db.corba.ItemDatabasePOA;

public class ItemDBA extends ItemDatabasePOA
{
   /**
    * adaptor database class
    */
   private Database db;
   private String table;

   public ItemDBA(String dbName, String table)
   {
      this.table = table;
      try
      {
         this.db = new Database(dbName);
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("MySQL driver not found. Exiting.");
         System.exit(1);
      }
   }

   /**
    * method that is creating sql statement for inserting the items in the
    * database if another item is placed in the specific location, than it will
    * be deleted
    */
   @Override
   public synchronized boolean stored(int id, int amount, String location)
   {
      String del = "DELETE FROM " + table + " WHERE location = ?";
      String sql = "INSERT INTO " + table
            + "(id,amount,location) VALUES (?,?,?)";
      try
      {
         db.update(del, location);
         if (db.update(sql, id, amount, location) == 1)
            return true;
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      return false;
   }

   /**
    * method that is returning an array of strings representing the locations
    * where you can find a specific item after the items are retrieved, they are
    * deleted from the database
    */

   @Override
   public synchronized String[] getLocations(int id, int amount)
   {

      ArrayList<String> locations = new ArrayList<String>();
      try
      {
         String sql = "SELECT location, amount FROM " + table + " WHERE id = ?";
         String del = "DELETE FROM " + table + " WHERE location = ?";
         ArrayList<Object[]> result = db.query(sql, id);

         for (int i = 0; i < result.size() && amount > 0; i++)
         {
            Object[] row = result.get(i);
            String location = (String) row[0];
			db.update(del, location);
            locations.add(location);
            // decrease the amount we need by the amount in the location i
            amount -= (int) (long) (Long) row[1];
         }
      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      return locations.toArray(new String[locations.size()]);
   }

   /**
    * Counts items with specified id (or any id if id == -1) at specified
    * location (or anywhere if location is "%" or null)
    */
   @Override
   public int countItems(int id, String location)
   {
      ArrayList<Object[]> result = null;
      int sum = -1;
      try
      {
         String sql = "SELECT SUM(amount) from " + this.table
               + " where location LIKE ?";
         if (location.isEmpty())
            location = "%";
         
         if (id > 0)
            result = db.query(sql + " AND id=?", location, id);
         else
            result = db.query(sql, location);

         Object[] row = result.get(0);
         BigDecimal res = (BigDecimal) row[0];
         sum = res.intValue();

      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }

      return sum;

   }

}
