package com.vtxlab.dsa.linkedllist;



import com.vtxlab.dsa.linkedllist.singly.Node;

public class LinkedList {
  Node head;

  public LinkedList push(int newData){
    Node node = new Node(newData);
    node.setNext(head);
    this.head = node;
    return this;
  }

  public Node peek(){
    return this.head;
  }

  public LinkedList deleteNode(int key){ //delete a specific int
    Node temp = head;
    Node prev = null;

    //If first node data == key, early return. Reduce Complexity
    //O(1)
    if (temp != null && temp.getData() == key){
      head = temp.getNext();
      return this;
    }

    //O(N)
    while(temp != null && temp.getData() != key){
      prev = temp;
      temp = temp.getNext();
      return this;
    }

    if (temp == null)
      return this;

      //Unlink the node from linked list
    prev.setNext(temp.getNext());

    return this;
  }


  public LinkedList print(){
    Node tnode = head;
    System.out.println("\nThis LinkedList :");
    while(tnode != null){   //search untill tnode is null.
      System.out.print(tnode.getData() + ", ");
      tnode = tnode.getNext();
    }
    return this;
  }


  //Static
  public static void print(LinkedList ll){
   Node tnode = ll.head;
    System.out.println("\nThis LinkedList :");
    while(tnode != null){   //search untill tnode is null.
      System.out.print(tnode.getData() + ", ");
      System.out.print("\n This data is odd : " + tnode.isNodeDataOdd());
      tnode= tnode.getNext();
    }
  }


  public static void main(String[] args) {
    
    LinkedList llist1 = new LinkedList();
    
    llist1.push(4);
    llist1.push(5).push(3).push(45).push(356).print().push(335).deleteNode(5);

    LinkedList.print(llist1);


  }
}
