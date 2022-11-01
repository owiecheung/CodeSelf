package com.vtxlab.dsa.linkedllist.doubly;

public class Node {

    Node head;
   private int data;
   private Node next;


    
   public Node(int d){
      data = d;
      next = null;
    }

    public Node getNext(){
      return this.next;
    }

    public void setNext(Node next){
      this.next=next;
  }

  public void push(int new_data){
    Node new_node = new Node(new_data);
    new_node.setNext(head);
    this.head = new_node;
  }

  public void printList(){
    Node tnode = head;
    while(tnode != null){
      System.out.print(tnode.data + ", ");
      tnode = tnode.getNext();
    }
  }
}
