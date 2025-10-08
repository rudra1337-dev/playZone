class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class SLL{
  SLL(){
    System.out.println("SLL initialised");
  }
  Node head = null, tail = null;
  int size;
  void insertLast(int data){
    //create a new node
    Node node = new Node(data);
    size++;
    //base condition
    if(head == null){
      head = tail = node;
      System.out.println("New node is created = "+data);
      return;
    }
    
    /*
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    
    temp.next = node;
    tail = node;
    */
    
    tail.next = node;
    tail = node;
    System.out.println("New node is created = "+data);
  }
  
  void insertFirst(int data){
    //create a new Node
    Node node = new Node(data);
    size++;
    
    //base condition
    if(head == null){
      head = tail = node;
      System.out.println("New node is created = "+data);
      return;
    }
    
    node.next = head;
    head = node;
    System.out.println("New node is created = "+data);
  }
  
  
  void insertAt(int data, int pos){
    //base case 
    if(pos == 0){
      insertFirst(data);
      return;
    }else if(pos == size){
      insertLast(data);
      return;
    }
    
    Node temp = head;
    int count = 0;
    while(temp != null && count < pos-1){
      temp = temp.next;
      count++;
    }
    if(temp == null){
      System.out.println("Position is out of bound");
      return;
    }
    
    Node node = new Node(data);
    node.next = temp.next;
    temp.next = node;
    size++;
    System.out.println("New node is created = "+data);
  }
  
  void print(){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data+", ");
      temp = temp.next;
    }
    System.out.println();
  }
  
  void removeLast(){
    //base case 
    if(head == null){
      System.out.println("No data  is  available at the moment");
      return;
    }else if(head == tail){
      System.out.println("Deleted element is "+head.data);
      size--;
      head = tail = null;
      return;
    }
  
  Node temp = head;
  while(temp.next != tail){
    temp = temp.next;
  }
  
  System.out.println("Deleted element is "+tail.data);
  size--;
  temp.next = null;
  tail = temp;
  }
  
  void removeFirst(){
    //base case 
    if(head == null){
      System.out.println("No data  is  available at the moment");
      return;
    }else if(head == tail){
      System.out.println("Deleted element is "+head.data);
      size--;
      head = tail = null;
      return;
    }
    
    System.out.println("Deleted element is "+head.data);
    size--;
    head = head.next;
  }
  
  void removeFrom(int pos){
    //base case
    if(head == null){
      System.out.println("No data  is  available at the moment");
      return;
    }else if(head == tail){
      System.out.println("Deleted element is "+head.data);
      head = tail = null;
      size--;
      return;
    }
    
    if(pos == 0){
      removeFirst();
    }else if(pos == size){
      removeLast();
    }
    
    Node temp = head;
    int count = 0;
    while(temp.next != null && count < pos-1){
      temp = temp.next;
      count++;
    }
    
    size--;
    System.out.println("Deleted element is "+temp.next.data);
    temp.next = temp.next.next;
    
  }
}

public class Ll{
  public static void main(String[] args){
    SLL ll = new SLL();
    ll.insertLast(2);
    ll.insertLast(3);
    ll.print();
    
    ll.insertFirst(1);
    ll.insertFirst(0);
    ll.insertAt(8,2);
    ll.print();
    
    ll.removeLast();
    ll.removeFirst();
    ll.removeFrom(2);
    ll.print();
    System.out.println(ll.size);
  }
}