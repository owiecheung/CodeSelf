package com.vtxlab.Week4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
  public static void main(String[] args) {
    
    Queue<Integer> q = new LinkedList<>();

    for(int i = 0 ; i < 5 ; i++){
      q.add(i);
    }

    System.out.println("\nElements of q :" + q);

    int removedElement = q.remove();
    System.out.println("\nremoved element = " + removedElement);
    System.out.println(q);

    int head = q.peek();
    System.out.println("\nHead of queue = " + head);

    System.out.println("\nremoved head of queue" + q.poll());
    System.out.println(q);

    int size = q.size();
    System.out.println("\nSize of queue " + size);


  }

}
