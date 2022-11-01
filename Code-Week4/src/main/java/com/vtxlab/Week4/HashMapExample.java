package com.vtxlab.Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

  //synchronized 有鎖 
  //non-synchronized 冇鎖 較快

public class HashMapExample {

  public static void main(String[] args) {

    //Hashtable
    Map<Integer,String> ht = new Hashtable<>();

    ht.put(101,"Ajay");
    ht.put(101, "Vijay");
    ht.put(102, "Ravi");
    ht.put(103, "Rahul");

    System.out.println("-------------Hash Table-------------");

    for(Map.Entry<Integer,String> m :ht.entrySet()){
      System.out.println("\n"+m.getKey()+" " + m.getValue());
    }


    //HashMap
    Map<Integer,String> hmap = new HashMap<>();

    hmap.put(100, "Amit");
    hmap.put(104,"Amit");
    hmap.put(101, "Vijay");
    hmap.put(106, "Rahul");
    hmap.put(108, "Vdje");
    hmap.put(120, "Bejr");
    hmap.put(164, "Greq");

    Iterator<Integer> it = hmap.keySet().iterator();
    while(it.hasNext()){
      Integer key = it.next();
      String mappedValue2 = hmap.get(key);

      System.out.println("\nKey : " + key + " Value : " + mappedValue2);
    }

    System.out.println("-------------Hash Map-------------");

    //1.
    for(Map.Entry<Integer,String> m : hmap.entrySet()){
      System.out.println(m.getKey() + " " + m.getValue() );
    }

     //2.
     hmap.forEach((x, y) -> {
      if (x == 101) {
        System.out.println(y);
      }
    });

    System.out.println("\n----------------------");
    Map<Integer , List<String>> ht2 = new Hashtable<>();
    //Entry
    List<String> string1 = new ArrayList<>();
    string1.add("abc");
    string1.add("bcd");
    ht2.put(101, string1);

    List<String> string2= new ArrayList<>();
    string1.add("ddded");
    string1.add("abcdefg");
    ht2.put(102, string2);

    List<String> string3 = new ArrayList<>();
    string3.add("vvvae");
    ht2.put(103, string3);

    ht2.size();
    ht2.containsKey(102);//true false
    System.out.println(ht2.size()) ;
    System.out.println(ht2.containsKey(104));

    System.out.println("\n----------------------");
    for ( Map.Entry<Integer, List<String>> m : ht2.entrySet()){
      for(String s :  m.getValue()){
        System.out.println(s);
      }
    }
  }
}
