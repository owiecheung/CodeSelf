package com.vtxlab.Week4;

import java.util.Hashtable;
import java.util.Iterator;

public class HashtableExample {

    public static void main(String[] args) {
      
      //1. Create HashTable
      Hashtable <Integer , String> hasht1 = new Hashtable<>();

      //2. Add mappings to hashtable
      hasht1.put(1, "Number one");
      hasht1.put(2, "Number Two");
      hasht1.put(3, "Number Three");
      hasht1.put(3, "New Number Three");    //overwirte 3
     // hasht1.put(4, null); (can be null?)

      System.out.println("\n"+hasht1);

      //3. Access a mapping by a key
      String value = hasht1.get(2);
      System.out.println(value);  //Number Two

      //4. Remove a mapping
      hasht1.remove(3);

      //5. Iterate over mapping
      Iterator<Integer> itr1 = hasht1.keySet().iterator();

      while(itr1.hasNext()){
          Integer key = itr1.next();
          String mappedValue = hasht1.get(key);
          System.out.println("Key : " + key + " Value : "+ mappedValue );
      }


    }
}
