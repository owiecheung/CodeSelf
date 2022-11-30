package vtxlab.app.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import vtxlab.app.Node;

public class Exercise2 {
  

  public static void main(String[] args) {

    Node list1_1 = new Node(1);
    Node list2_2 = new Node(2);
    Node list3_4 = new Node(4);
    list1_1.setNextNode(list2_2);
    list2_2.setNextNode(list3_4);
    list3_4.setNextNode(null);

    Node currencyNode = list1_1;


    while(currencyNode.getNext() != null){
      System.out.println(currencyNode.getNext());
      currencyNode = currencyNode.getNext();


    }
  }
  
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     }


  public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode fakeHead = new ListNode(0);
    ListNode current = fakeHead;
  
    while (l1 != null || l2 != null) {
      if (l1 == null || (l2 != null && l1.val >= l2.val)) {
        current.next = l2;
        current = l2;
        l2 = l2.next;
      } else {
        current.next = l1;
        current = l1;
        l1 = l1.next;
      }
    }
    return fakeHead.next;
  }
  
}
