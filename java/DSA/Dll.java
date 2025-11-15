class Node{
 int data;
 Node prev = null;
 Node next = null;
 
 Node(int data){
   this.data = data;
 }
}

class node{
  int data;
  node next = node;
}

class DLL{
  Node head;
  Node tail;
  int size;
  
  void addFirst(int data){
    Node node = new Node(data);
    System.out.println("Node created-"+node.data);
    if(head == null){
    head = tail = node;
    size++;
    return;
    }
    
    node.next = head;
    head.prev = node;
    head = node;
    size++;
    
  }
  
  void addLast(int data){
    Node node = new Node(data);
    System.out.println("Node created-"+node.data);
    if(head == null){
      head = tail = node;
      size++;
      return;
    }
    
    this.tail.next = node;
    node.prev = tail;
    tail = node;
    size++;
  }
  
  
  void removeFirst(){
    if(head == null){
      System.out.println("DLL is empty");
      return;
    }else if(head.next == null){
      System.out.println("Deleted node is- "+head.data);
      head = tail = null;
      size--;
      return;
    }
    System.out.println("Deleted node is- "+head.data);
    head = head.next;
    head.prev = null;
    size--;
  }
  
  void removeLast(){
    if(head == null){
      System.out.println("DDl is empty");
      return;
    }else if(head.next == null){
      System.out.println("Deleted node is- "+head.data);
      head = tail = null;
      size--;
      return;
    }
    System.out.println("Deleted node is- "+tail.data);
    tail = tail.prev;
    tail.next = null;
    size--;
  }
  
  
  void print(){
    Node temp = head;
    System.out.print("NULL<->");
    while(temp != null){
      System.out.print(temp.data+"<->");
      temp = temp.next;
    }
    System.out.println("<->NULL");
  }
  
  Node reverse(){
    if(head == null || head.next == null){
      return head;
    }
    
    Node prev = null, curr = head;
    while(curr != null){
      Node next = curr.next;
      curr.next = prev;
      curr.prev = next;
      prev = curr;
      curr = next;
    }
    tail = head;
    head = prev;
    return prev;
  }
}

public class Dll{
  
  public static void main(String[] args){
    System.out.println("Welcome to Doubly Linkedlist");
    
    DLL dll = new DLL();
    
    dll.addFirst(1);
    dll.addFirst(2);
    dll.addFirst(3);
    dll.print();
    
    dll.addLast(3);
    dll.addLast(2);
    dll.addLast(1);
    dll.print();
    
    dll.removeFirst();
    dll.removeLast();
    dll.print();
    
    dll.reverse();
    dll.print();
  }
}