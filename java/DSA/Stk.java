import java.util.*;

class StackA{
  int[] arr;
  int top = -1;
  int size;
  
  StackA(int size){
    this.size = size;
    arr = new int[size];
  }
  
  void push(int data){
    if(top == size-1){
      System.out.println("Stack is full");
      return;
    }
    
    arr[++top] = data;
    System.out.println("Data pushed -"+arr[top]);
  }
  
  int pop(){
    if(top == -1){
      System.out.println("Stack is empty");
      return -1;
    }
    
    System.out.println("Deleted eement is -"+arr[top]);
    return arr[top--];
  }
  
  int peek(){
    if(top == -1){
      System.out.println("Stack is empty");
      return -1;
    }
    return  arr[top];
  }
    
  boolean isEmpty(){
    return top == -1;
  }
  
  boolean isFull(){
    return top == size-1;
  }
  
}

class StackAl{
  int top;
  ArrayList<Integer> ll;
  
  StackAl(){
    this.ll = new ArrayList<>();
    top = -1;
  }
  
  void push(int data){
    ll.add(++top,data);
    System.out.println("Data pushed - "+ll.get(top));
  }
  
  int pop(){
    if(ll.isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }
    System.out.println("Deleted element is - "+ll.get(top));
    return ll.remove(top--);
  }
  
  int peek(){
    if(ll.isEmpty() || top == -1){
      System.out.println("Stack is empty");
      return -1;
    }
    
    System.out.println("Top = "+ll.get(top));
    return ll.get(top);
  }
  
  boolean isEmpty(){
    return ll.isEmpty();
  }
  
}

class StackLl{
  class Node{
    int data;
    Node next;
    
    Node(int data){
      this.data = data;
      this.next = null;
    }
  }
  Node head = null, tail = null;
  Node top = head;
  
  void push(int data){
    Node node = new Node(data);
    System.out.println("Data pushed - "+node.data);
    if(top == null){
      head = tail = top = node;
      return;
    }
    node.next = head;
    head = node;
    top = head;
  }
  
  int pop(){
    if(head == null){
      System.out.println("Stack is empty");
      return -1;
    }else if(head.next == null){
      System.out.println("Deleted element is - "+top.data);
      int data = top.data;
      head = tail = top = null;
      return data;
    }
    System.out.println("Deleted element is - "+top.data);
    int data = top.data;
    head = head.next;
    top = head;
    return data;
  }
  
  int peek(){
    if(head == null){
      System.out.println("Stack os empty");
      return -1;
    }
    System.out.println("Top = "+ top.data);
    return top.data;
  }
  
  boolean isEmpty(){
    return top == null;
  }
}

class StackB{
  void pushBottom(Stack<Integer> s, int data){
    if(s.isEmpty()){
      s.push(data);
      return;
    }
    
    int temp = s.pop();
    pushBottom(s, data);
    s.push(temp);
    
  }
  
  void reverseStr()
}

public class Stk{
  public static void main(String args[]){
    System.out.println("Welcome to stack");
    /*
    //StackA s = new Stack(3);
    //StackAl s = new StackAl();
    StackLl s = new StackLl();
    
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.peek();
    System.out.println(s.isEmpty());
    
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    s.peek();
    
    System.out.println(s.isEmpty());
    
    */
    
    
    Stack<Integer> s = new Stack<>();
        
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    
    StackB ss = new StackB();
    ss.pushBottom(s, 99);
    System.out.println(s);
    
  }
}