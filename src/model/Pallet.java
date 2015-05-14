package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The purpose of the pallet is to hold {@link Item} objects.
 * 
 */
public class Pallet implements Iterator<Item>, Iterable<Item>, Serializable
{
   private static final long serialVersionUID = 3810883112346264204L;
   /** grams */
   public static final int MAX_WEIGHT = 1000 * 1000;
   /** cubic centimeters */
   public static final int MAX_VOLUME = 120 * 80 * 150;
   
   /** 
    * an empty pallet used instead of null in some methods.
    * No items can be added on this pallet.
    */
   public static final Pallet EMPTY = new Pallet();
   
   private ArrayList<Item> items;
   private int weight;
   private int volume;
   
   /**
    * creates a new empty pallet
    */
   public Pallet()
   {
      items = new ArrayList<Item>();
      weight = 0;
      volume = 0;
   }
   
   /**
    * @return total weight of items on the pallet
    */
   public int getWeight()
   {
      return weight;
   }

   /**
    * @return total volume of items on this pallet
    */
   public int getVolume()
   {
      return volume;
   }
   
   /**
    * @return amount of items on this pallet
    */
   public int getAmount()
   {
      return items.size();
   }

   /**
    * Adds specified item on the pallet. Fails if the item is null,
    * the weight or volume would exceed the limit or if this pallet
    * is {@link Pallet#EMPTY}
    * @param item the item to be added
    * @return <code>true</code> if the item was successfully added, <code>false</code> otherwise
    */
   public boolean add(Item item)
   {
      if(item == null || weight + item.weight > MAX_WEIGHT || volume + item.volume > MAX_VOLUME || this == EMPTY)
         return false;
      weight += item.weight;
      volume += item.volume;
      return items.add(item);
   }

   /**
    * @return <code>true</code> if there is at least one item
    * on the pallet, <code>false</code> if the pallet is empty
    */
   @Override
   public boolean hasNext()
   {
      return !items.isEmpty();
   }

   /**
    * removes and returns one item from the pallet
    * @return an item from the pallet
    */
   @Override
   public Item next()
   {
      if(items.isEmpty())
         throw new IllegalStateException("no next");
      Item i = items.remove(items.size()-1);
      weight -= i.weight;
      volume -= i.volume;
      return i;
   }

@Override
public void remove() {
	// next() already removes
}

@Override
public Iterator<Item> iterator() {
	return this;
}

}
