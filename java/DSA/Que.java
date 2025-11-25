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


class QueueProb{
    
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

  }
}