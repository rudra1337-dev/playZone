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

  String reversString(String str){

    Stack<Character> s = new Stack<>();
    
    for(int i= 0; i<=str.length()-1; i++){
      s.push(str.charAt(i));
    }

    StringBuilder ss = new StringBuilder();

    for(int i= s.size()-1; i>=0; i--){
      ss.append(s.pop());
    }
    
    return ss.toString();
  }

  
  
  void reverseStk(Stack<Integer> s){
    if(s.isEmpty()){
      return;
    }

    int temp = s.pop();
    reverseStk(s);
    s = insertAtBtm(s,temp);
  }

  Stack<Integer> insertAtBtm(Stack<Integer> s, int data){
    if(s.isEmpty()){
      s.push(data);
      return s;
    }

    int temp = s.pop();
    s = insertAtBtm(s, data);
    s.push(temp);

    return s;
  }


  void stockSpan(int[] stocks, int[] span){
      Stack<Integer> s = new Stack<Integer>();

      span[0] = 1;
      s.push(0);

      for(int i = 1; i<=stocks.length-1; i++){
        int curr = stocks[i];

        while(!s.isEmpty() && curr >= stocks[s.peek()]){
          s.pop();
        }

        if(s.isEmpty()){
          span[i] = i+1;
        }else{
          span[i] = i-s.peek();
        }
        s.push(i);
      }

      return;
  }






  void nextGreater(int[] arr, int[] neGr){
    Stack<Integer> s = new Stack<>();

    neGr[arr.length-1] = -1;
    s.push(arr[arr.length-1]);

    for(int i=arr.length-2; i>=0; i--){
      int curr = arr[i];

      while(!s.isEmpty() && curr >= s.peek()){
        s.pop();
      }

      if(s.isEmpty()){
        neGr[i] = -1;
      }else{
        neGr[i] = s.peek();
      }

      s.push(arr[i]);
    }
  }


/*
  boolean isPaired(String str){
      Stack<Character> s = new Stack<>();

      for(int i = 0; i < str.length(); i++){
          char ch = str.charAt(i);

          // opening brackets
          if(ch == '(' || ch == '{' || ch == '['){
              s.push(ch);
          } else {
              // closing bracket case
              if(s.isEmpty()) return false;

              char top = s.peek();

              if( (top == '(' && ch == ')') ||
                  (top == '{' && ch == '}') ||
                  (top == '[' && ch == ']') ){
                  s.pop();
              } else {
                  return false;
              } 
          }
      }

      return s.isEmpty();
  }

*/

  boolean isPaired(String str){
    Stack<Character> s = new Stack<>();

    for(int i=0; i<=str.length()-1; i++){
      char ch = str.charAt(i);

      if(ch == '(' || ch == '{' || ch == '['){
        s.push(ch);
      }else{
        //close condition
        if(s.isEmpty()){
          return false;
        } 
        if( (s.peek()=='(' && ch==')')
        || (s.peek()=='{' && ch=='}')
        || (s.peek()=='[' && ch==']')){
          s.pop();
        }else{
          return false;
        }
      }
    }
    
    return true;
  }
  
  boolean duplicateParenthisis(String str){
    Stack<Character> s = new Stack<>();
    
    for(int i=0; i<=str.length()-1; i++){
      char ch = str.charAt(i);
      int count = 0;
      
      
      if(ch==')'){
        while(s.peek()!='('){
          s.pop();
          count++;
        }
        
        s.pop();
        if(count<1) return true;
      }else{
        s.push(ch);
      }
    }
    
    return false;
  }



String infixToPostfix(String str){
  Stack<Character> s = new Stack<>();
  StringBuilder res = new StringBuilder();
  
  for(int i= 0; i<=str.length()-1; i++){
    char ch = str.charAt(i);
    
    if(Character.isLetterOrDigit(ch)){
      res.append(ch);
    }else if(ch == '('){
      s.push(ch);
    }else if(ch==')'){
      while(!s.isEmpty() && s.peek()!='('){
        res.append(s.pop());
      }
      s.pop();
    }else{
      //operators
      while(!s.isEmpty() && prec(ch) <= prec(s.peek())){
        res.append(s.pop());
      }
      s.push(ch);
    }
  }
  
  while(!s.isEmpty()){
    res.append(s.pop());
  }
  return res.toString();
}

int prec(char ch){
  switch(ch){
    case '^': return 3;
    case '/':
    case '*': return 2;
    case '+':
    case '-': return 1;
  }
  return -1;
}
  
  int postfixEval(String str){
    Stack<Integer> s = new Stack<>();
    
    for(int i = 0; i<= str.length()-1; i++){
      char ch = str.charAt(i);
      
      if(Character.isDigit(ch)){
        s.push(ch-'0'); 
      }else{
        int b=s.pop(), a=s.pop();
        int res = 0;
        if(ch=='+')res = a+b;
        if(ch == '-')res = a-b;
        if(ch == '*')res = a*b;
        if(ch == '/')res = a/b;
        s.push(res);
      }
      
    }
    return s.pop();
  }



  int presc(char ch){
    switch(ch){
      case '^': return 3;
      case '/':
      case '*': return 2;
      case '+':
      case '-': return 1;
    }

    return -1;
  }


  String infixToPrefix(String str){
    Stack<Character> s = new Stack<>();
    StringBuilder res = new StringBuilder();


    //reverse the infix
    for(int i=0; i<=str.length()-1; i++){
      s.push(str.charAt(i));
    }

    for(int i=0; i<=str.length()-1; i++){
      res.append(s.pop());
      if(res.charAt(i)=='(') res.setCharAt(i,')');
      else if(res.charAt(i)==')') res.setCharAt(i,'(');
    }
    str = res.toString();



    //convert infix to postfix
    res = new StringBuilder();
    s = new Stack<>();

    for(char ch : str.toCharArray()){

      if(Character.isLetterOrDigit(ch)){
        res.append(ch);
      }else if(ch=='('){
        s.push(ch);
      }else if(ch==')'){
        while(!s.isEmpty() && s.peek()!=')'){
          res.append(s.pop());
        }
        s.pop();
      }else{
        while(!s.isEmpty() && presc(ch) <= presc(s.peek())){
          res.append(s.pop());
        }
        s.push(ch);
      }
    }

    while(!s.isEmpty()){
      res.append(s.pop());
    }



    //reverse the postfix res = prefix
    for(int i=0; i<=str.length()-1; i++){
      s.push(res.charAt(i));
    }

    res = new StringBuilder();
    while(!s.isEmpty()){
      res.append(s.pop());
      // if(res.charAt(i)=='(') res.setCharAt(i,')');
      // else if(res.charAt(i)==')') res.setCharAt(i,'(');
    }

    return res.toString();
  }
  
  
  
  
  int prefixEval(String str){
    StringBuilder st = new StringBuilder(str);
    str = st.reverse().toString();
    StringBuilder sb = new StringBuilder();
    Stack<Integer> s = new Stack<>();
    
    for(char ch : str.toCharArray()){
      if(Character.isDigit(ch)){
        s.push(ch-'0');
      }else{
        //operator case
        int b=s.pop(), a=s.pop();
        int res = 0;
        if(ch=='+') res = a+b;
        if(ch=='-') res = a-b;
        if(ch=='*') res = a*b;
        if(ch=='/') res = a/b;
        s.push(res);
      }
    }
    
    return s.pop();
  }

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

    String str = "This is rudra";

    String ls = ss.reversString(str);
    System.out.println(ls);

    System.out.println(s);
    ss.reverseStk(s);
    System.out.println(s);





    int stocks[] = {100,80,60,70,60,85,100};
    int[] span = new int[stocks.length];

    ss.stockSpan(stocks, span);

    for(int i = 0; i<=span.length-1; i++){
      System.out.print(span[i]+",");
    }
    System.out.println();



    int arr[] = {6,8,0,1,3};
    int[] neGr = new int[arr.length];
   
    ss.nextGreater(arr, neGr);

    for(int i=0; i<=neGr.length-1; i++){
      System.out.print(neGr[i]+",");
    }
    System.out.println();




    String sss = "ssyt{([])}";
    
    System.out.print(ss.isPaired(sss));
    
    
    
    String sp = "((c+d)+(a+b))";
    System.out.println("Duplicate parenthisis = "+ss.duplicateParenthisis(sp));
    
    String post = ss.infixToPostfix("((A+B)*C)-(D-E)*(F+G)");
    System.out.println(post);
    System.out.println(ss.postfixEval("23+54*62/-3+*"));

    String pref = ss.infixToPrefix("X+Y*Z^W");
    System.out.println(pref);
    System.out.println(ss.prefixEval("+9*26"));
  }
}