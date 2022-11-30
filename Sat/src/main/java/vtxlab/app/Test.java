package vtxlab.app;

import java.util.Arrays;

public class Test {
  
  public static void main(String[] args) throws Exception {

  //  ArrayList
    int[] b = {1,2,3,4};
    int[] c = new int[7];

    c[0]= 37;
    c[1] =43;
    c[2] =24;
    c[3] = 79; 
    c[4] = 32;
    c[5] = 98;
    c[6] = 22;

    int max =0;;
    for(int i =0; i < c.length  ; i++){

      if (max < c[i]){
        max = c[i];
      }
    }
    System.out.println(max);

    
    Node node3 = new Node(3);
    Node node5 = new Node(5);
    Node node9 = new Node(9);

    node3.setNextNode(node5);
    node5.setNextNode(node9);
    node9.setNextNode(null);

    //Insert no need pointer
    Node node4 = new Node(4);
    node3.setNextNode(node4);
    node4.setNextNode(node5);


    Node currencyNode = node3;

    while( currencyNode.next !=null){
      if(currencyNode.data == 5){
        System.out.println(currencyNode.data);
        break;
      }
      currencyNode = currencyNode.next;
    }

    Node node23 = new Node(23);
    Node node45 = new Node(45);
    Node node12 = new Node(12);
    Node node10 = new Node(10);
    Node node98 = new Node(98);
    Node node17 = new Node(17);
    Node node55 = new Node(55);

    node23.setNextNode(node45);
    node45.setNextNode(node12);
    node12.setNextNode(node10);
    node10.setNextNode(node98);
    node98.setNextNode(node17);
    node17.setNextNode(node55);
    node55.setNextNode(null);


    Node.findTheSizeofLinkedList(node23);

    Node.findTheMiddleofLinkedList(node23);


    int[] nums = {2,5,1,3,4,7};
    int n = 3;
    System.out.println(Arrays.toString(shuffle(nums, n)));




    Node list1_1 = new Node(1);
    Node list2_2 = new Node(2);
    Node list3_4 = new Node(4);
    list1_1.setNextNode(list2_2);
    list2_2.setNextNode(list3_4);


    Node currencyNode1 = list1_1;

    Node list2_1 = new Node(1);
    Node list2_3 = new Node(3);
    Node list2_4 = new Node(4);

    list2_1.setNextNode(list2_3);
    list2_3.setNextNode(list2_4);

    Node currencyNode2 = list2_1;

    


    }

    
    public static int[] shuffle(int[] nums, int n) {
      int[] ans = new int[ 2 * n];
      for (int i = 0; i < n; ++i) {
          ans[2 * i] = nums[i];
          ans[2 * i + 1] = nums[i + n];
      }
      return ans;
  }

  public static Node mergeTwoLists(Node l1, Node l2) {
    Node preHead = new Node(0);
    Node last = preHead;
    
    while(l1 != null && l2 != null) {
        if(l1.data > l2.data) {
            last.next = l2;
            l2 = l2.next;
        } else {
            last.next = l1;
            l1 = l1.next;
        }
        last = last.next;
    }
    
    if(l1 == null) {
        last.next = l2;
    } else {
        last.next = l1;
    }
    
    return preHead.next;
}

  }


