import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueA{
  int[] arr;
  int rear, front;
  int size;
  
  QueueA(int size){
    this.size = size;
    arr = new int[size];
    rear = -1;
    front = 0;
  }


  void enqueue(int data){
    //OVERFLOW CONDITION
    if(rear == size-1){
      System.out.println("Queueis full");
      return;
    }
    arr[++rear] = data;
    System.out.println(arr[rear]+" is inserted");
  }

  int dequeue(){
    //UNDERFLOW CONDITION
    if(front > rear){
      System.out.println("Queue is empty");
      return -1;
    }

    int data = arr[front];
    for(int i = 0; i<= rear-1; i++){
      arr[i] = arr[i+1];
    }
    rear--;
    System.out.println(data+" is deleted");
    return data;
  }

  int peek(){
    if(front > rear) return -1;
    return arr[front];
  }

  boolean isFull(){
    return rear == size-1;
  }

  boolean isEmpty(){
    return front > rear;
  }


}


class QueueL {
    
    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue(int data){
        Node node = new Node(data);

        if(front == null){   // first element
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        System.out.println(data + " is added");
    }


    int dequeue(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if(front == null) rear = null;   // queue became empty

        System.out.println(data + " is deleted");
        return data;
    }


    int peek(){
        if(front == null){
            System.out.println("Queue is empty");
            return -1;
        }

        System.out.println("Front element = " + front.data);
        return front.data;
    }


    boolean isEmpty(){
        return front == null;
    }
}


class QueueS{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        System.out.println(data +" is added");
    }

    int dequeue(){
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        System.out.println(s1.peek()+" is deleted");
        return s1.pop();
    }

    int peek(){
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        System.out.println("front element is "+s1.peek());
        return s1.peek();
    }

    boolean isEmpty(){
        return s1.isEmpty();
    }

}


class StackQ{
  Queue<Integer> q1 = new LinkedList<>();
  Queue<Integer> q2 = new LinkedList<>();


  void push(int data){
    if(!q1.isEmpty()){
      q1.add(data);
    }else{
      q2.add(data);
    }
    System.out.println(data+" is pushed");
  }

  int pop(){
    if(q1.isEmpty() && q2.isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }

    int top = -1;
    if(!q1.isEmpty()){
      while(!q1.isEmpty()){
        top = q1.remove();
        if(q1.isEmpty()){
          break;
        }
        q2.add(top);
      }
    }else{
      while(!q2.isEmpty()){
        top = q2.remove();
        if(q2.isEmpty()){
          break;
        }
        q1.add(top);
      }
    }

    System.out.println(top+ " is deleted");
    return top;
  }

  int peek(){
    if(q1.isEmpty() && q2.isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }

    int top = -1;
    if(!q1.isEmpty()){
      while(!q1.isEmpty()){
        top = q1.remove();
        q2.add(top);
      }
    }else{
      while(!q2.isEmpty()){
        top = q2.remove();
        q1.add(top);
      }
    }

    System.out.println("Top = "+top);
    return top;
  }


  boolean isEmpty(){
    return q1.isEmpty() && q2.isEmpty();
  }

}



class QueueProb{
    
  char firstNonRepeatingEle(String str){
    Queue<Character> q = new LinkedList<>();
    int[] count = new int[26];
    char nonRep = '*';


    for(char ch : str.toCharArray()){
      count[ch-'a']++;
      q.add(ch);
      while(!q.isEmpty() && count[q.peek()-'a']>1){
        q.remove();
      }
      if(q.isEmpty()){
        nonRep = '*';
        continue;
      }
      nonRep = q.peek();
    }
    return nonRep;
  }


  Queue<Integer> interleave(Queue<Integer> q){
    Queue<Integer> q1 = new LinkedList<>();
    int size = q.size()/2;
    
    for(int i=0; i<=size-1; i++){
      q1.add(q.remove());
    }

    int i = 2;
    while (!q1.isEmpty()) {
      if(i%2==0){
        q.add(q1.remove());
      }else{
        q.add(q.remove());
      }
      i++;
    }
    q.add(q.remove());

    return q;
  }


  void reverse(Queue<Integer> q){
    Stack<Integer> s = new Stack<>();

    while(!q.isEmpty()) s.push(q.remove());
    while(!s.isEmpty()) q.add(s.pop());
  }
}


public class Que{
  public static void main(String[] args){
    System.out.println("Welcome to QUEUE");
    

    //QueueA q = new QueueA(3);
    //QueueL q = new QueueL();
    // Queue q = new LinkedList<>();
    QueueS q = new QueueS();

    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(1);
    q.enqueue(8);
    System.out.println("PEEK="+q.peek()+"\n"+/*q.isFull()+*/q.isEmpty());
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    System.out.println("PEEK="+q.peek()+"\n"+/*q.isFull()+*/q.isEmpty());





    QueueProb qq = new QueueProb();

    System.out.println("First non repeating ele = "+qq.firstNonRepeatingEle("aadbcb"));


    Queue<Integer> s = new LinkedList<>();
    s.add(2);
    s.add(3);
    s.add(1);
    s.add(8);
    s.add(5);
    s.add(6);
    int sz = s.size();
    //qq.interleave(s);
    qq.reverse(s);
    for(int i= 0; i<= sz-1; i++){
      System.out.println(s.remove());
    }

  }
}