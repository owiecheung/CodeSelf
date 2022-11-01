package com.vtxlab.Week4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DemoSet {

  public static void main(String[] args) {
    
  //Double double1 = new Double(12.0);
  //Double double2 = Double.valueOf(12.0);

  Set<String> hs = new HashSet<>();

  hs.add("A");
  hs.add("B");
  hs.add("C");
  hs.add("D");
  hs.add("B");
  hs.add("V");

  System.out.println(hs);

  hs.remove("B");
  System.out.println(hs);

    List<Integer> integer = new ArrayList<>();

    integer.add(100);
    integer.add(60);
    integer.add(53);
    integer.add(36);
    integer.add(53);
    integer.add(24);
    integer.add(53);

    System.err.println(integer);

    //Queue FIFO

    //Deque FIFO and LIFO

    Deque<String> deque = new LinkedList<>();
    deque.add("Element 1");         //Add at the Last
    deque.addFirst("Eelement 2");   //Add at the First
    deque.addLast("addLast");       //Add at the last
    deque.push("push");             //Add at the First
    deque.offer("Offer");           //Add at the last
    deque.offerLast("Element 5 offerLast"); //Add at the last

    System.out.println(deque);

    SortedSet<String> ts =new TreeSet<>();

    ts.add("Hong Kong");
    ts.add("Japan");
    ts.add("Korea");
    ts.add("Brazil");

    ts.add("Japan");
    System.out.println(ts);

    ts.remove("Japan");
    System.out.println(ts);

    Iterator<String> i =ts.iterator();
    while (i.hasNext()){
      System.out.println(i.next());
    }
  }
}
