import java.util.*;
public class Example{
    public static int fib(int n){
        int fib=0;
        if(n<=1){
            return n; 
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        //System.out.print("Enter a number here:");
        //int n = s.nextInt();
        //System.out.print("Fibonachhi of "+n+" is "+fib(n));
        
        int[] arr= new int[6];
        
        for(int a : arr){
            System.out.printf("%d,",a);
        }
    }
}