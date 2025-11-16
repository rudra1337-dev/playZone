
class Stack{
  int[] arr;
  int top = -1;
  int size;
  
  Stack(int size){
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
  
  int peak(){
    return  arr[top];
  }
    
  boolean isEmpty(){
    return top == -1;
  }
  
  boolean isFull(){
    return top == size-1;
  }
  
}

public class Stk{
  public static void main(String args[]){
    System.out.println("Welcome to stack");
    
    Stack s = new Stack(3);
    
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.isEmpty()+","+s.isFull());
    
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    
    System.out.println(s.isEmpty()+","+s.isFull());
  }
}