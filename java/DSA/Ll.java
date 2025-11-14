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
  
  void print(Node head){
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
      return;
    }else if(pos == size-1){
      removeLast();
      return;
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
  
  void reverse(){
    if(head == null || head.next == null){
      return;
    }
    Node pre = null, curr = head, next = null;
    
    while(curr != null){
      next = curr.next;
      curr.next = pre;  //change [ointer to preveous
      //shift to next Node
      pre = curr;
      curr = next;
    }
    tail = head;
    head = pre;
  }
  
  
  void reverseRec(Node curr, Node pre){
    if(curr == null){
      tail = head;
      head = pre;
      return;
    }
    Node next = curr.next;
    curr.next = pre;
    reverseRec(next, curr);
  }
  
  int search(int key){
    return searchHelp(this.head,key);
  }
  
  
  int searchHelp(Node temp, int key){
    if(head == null){
      System.out.println("LL is empty");
      return -1;
    }
    
    if(temp ==null){
      System.out.println("Key not found");
      return -1;
    }
    
    if(temp.data == key){
      System.out.println("Key found");
      return 0;
    }
    
    int idx = searchHelp(temp.next, key);
    if(idx == -1){
      System.out.println("Key not found");
      return -1;
    }
    return idx+1;
  }
  
  
  boolean hasCycle(){
    if(head == null) return false;
    
    Node slow = head;
    Node fast = head;
    
    while(fast != null && fast.next != null){
      slow = slow.next;  //movong one step at a time
      fast = fast.next.next;  //moving two steps at a time
      
      if(fast == slow) return true;
    }
    return false;
  }
  
  void removeCycle(){
    if(head == null){
      return;
    }
    
    //1- detect cycle
    Node slow = head, fast = head;
    boolean cycle = false;
    
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      
      if(slow == fast){
        cycle = true;
        break;
      }
    }
    
    if(!cycle){
      System.out.println("Cycle not found");
      return;
    }
    
    //get the meeting point
    Node pre = null;
    
    slow = head;
    while(slow != fast){
      pre = fast;
      slow = slow.next;
      fast = fast.next;
    }
    
    //Removing the cycle
    
    pre.next = null;
    System.out.println("Cycle removed");
  }
  
  
  
  Node mergeSort(Node head){
    if(head == null || head.next == null){
      System.out.println("Already sorted");
      return head;
    }
    
    Node mid = getMid(head);
    Node rightHead = mid.next;
    mid.next = null;
    Node leftHead = head;
    
    Node newLeft = mergeSort(leftHead);
    Node newRight = mergeSort(rightHead);
    
    return merge(newLeft,newRight);
  }
  
  private Node getMid(Node head){
    
    Node slow = head;
    Node fast = head.next;
    
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    } 
    
    return slow;
  }
  
  private Node merge(Node h1, Node h2){
    Node mergedll = new Node(-1);
    Node temp = mergedll;
    
    while(h1 != null && h2 != null){
      if(h1.data <= h2.data){
        temp.next = h1;
        temp = temp.next;
        h1 = h1.next;
        
        this.tail = temp;
      }else if(h1.data > h2.data){
        temp.next = h2;
        temp = temp.next;
        h2 = h2.next;
        
        this.tail = temp;
      }
    }
    
    while(h1 != null){
      temp.next = h1;
        temp = temp.next;
        h1 = h1.next;
        
        this.tail = temp;
    }
    
    while(h2 != null){
      temp.next = h2;
        temp = temp.next;
        h2 = h2.next;
        
        this.tail = temp;
    }
    
    this.head = mergedll.next;
    
    return this.head;
  }
  
  private Node getMid1(Node head){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    
    return slow;
  }
  
  private Node rev1(Node head){
    Node pre = null;
    Node curr = head;
    
    while(curr != null){
      Node next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }
  
  boolean isPalendrome(Node head){
    if(head == null || head.next == null){
      return true;
    }
    
    //1. find the mid
    Node mid = getMid1(head);
    
    //2. reverse from mid to insertLast
    Node reversed = rev1(mid);
    
    Node left = head;
    Node right = reversed;
    
    //3.  Compare 
    while(right != null){
      if(left.data != right.data){
        return false;
      }
      left = left.next;
      right = right.next;
    }
    
    return true;
  }
  
  
  Node zigzag(Node head){
    if(head == null || head.next == null){
      return head;
    }
    
    //1.find mid
    Node slow = head, fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    
    Node mid = slow;
    
    //2. reverse the second half
    Node prev = null, curr = mid.next; //move the start to the second first 
    mid.next = null;
    while(curr != null){
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    
    Node lh = head;
    Node rh = prev;
    
    //3. zigzag merge
    Node leNext = lh, riNext = rh;
    while(lh != null && rh != null){
      
      leNext = leNext.next;
      lh.next = rh;
      lh = leNext;
      riNext = riNext.next;
      rh.next = lh;
      rh = riNext;
      
      
    }
    
    return head;
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
    
    
    ll.insertLast(3);
    ll.insertLast(4);
    ll.insertLast(5);
    ll.print();
    ll.reverse();
    ll.print();
    ll.reverseRec(ll.head, null);
    ll.print();
    ll.search(40);
    
    System.out.println(ll.size);
    
    ll.tail.next = ll.head.next.next;
    System.out.println("Loop -"+ll.hasCycle());
    ll.removeCycle();
    System.out.println("Loop -"+ll.hasCycle());
    ll.print();
    
    Node sort = ll.mergeSort(ll.head);
    System.out.println(sort);
    ll.print(sort);
    
    /*
    ll.removeLast();
    ll.removeLast();
    ll.insertLast(3);
    //ll.insertLast(1);
    //ll.insertAt(4,2);
    ll.print();
    System.out.println("Palendrome- "+ll.isPalendrome(ll.head));
    */
    
    ll.print();
    ll.zigzag(ll.head);
    ll.print();
  }
}