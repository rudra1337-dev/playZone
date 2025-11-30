
public class BitManu{


    public static void evenOrOdd(int n){
        int bitMask = 1;

        if((n & bitMask) == 0){
            System.out.println(n+" is even");
        }else{
            System.out.println(n+" is odd");
        }
    }

    public static void main(String[] args){
        System.out.println("WELCOMETO BITMANUPULATIONS");

        evenOrOdd(3);
        evenOrOdd(4);


    }
}