package vtxlab.app;

public class Node{
  int data;
  Node next;
  int count;

  public Node(int data){
    this.data = data;
    this.next = null;
    count++;
  }

  public void setNextNode(Node data){
    this.next = data;
  }

  public Node getNext(){
    return this.next;
  }

  public static int findTheSizeofLinkedList(Node head){
    Node currencyNode2 = head;
    int size =0;
    while( currencyNode2.next !=null){

      currencyNode2 = currencyNode2.next;
      size++;
    }
    System.out.println(size);
    return size;
  }

  public static void findTheMiddleofLinkedList(Node head) throws Exception{
    Node currencyNode = head;
    int size = 0;
     size = findTheSizeofLinkedList(head)/2;
    if(head == null){
      throw new NullPointerException();
    }

    for(int i =0; i<size ; i++){
      currencyNode = currencyNode.next;
    }
    System.out.println(currencyNode.data);

    }


    public static void findTheMiddleofLinkedList2(Node head) throws Exception{
      Node quickpointer = head;
      Node slowpointer = head;

      while( quickpointer.next != null){
        quickpointer = quickpointer.next.next;
        slowpointer = slowpointer.next;
      }
    }

  }


