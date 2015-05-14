package model;

import java.io.Serializable;

public final class Item implements Serializable
{
   private static final long serialVersionUID = -2827857345375638821L;
   public final int id;
   public final String name;
   public final String description;
   /** grams */
   public final int weight;
   /** cubic centimeters */
   public final int volume;
   
   /**
    * @param id item id
    * @param name short name
    * @param description full description
    * @param weight grams
    * @param volume cubic centimeters
    */
   public Item(int id, String name, String description, int weight, int volume)
   {
      if(weight < 1 || volume < 1)
         throw new IllegalArgumentException("minumum weight and volume of Item is 1");
      this.id = id;
      this.name = name;
      this.description = description;
      this.weight = weight;
      this.volume = volume;
   }
   
   public Item copy()
   {
	   return new Item(id, name, description, weight, volume);
   }
    
}
