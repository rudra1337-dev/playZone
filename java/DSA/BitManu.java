
public class BitManu{

    //CHECK N IS EVEN OR ODD
    public static void evenOrOdd(int n){
        int bitMask = 1;

        if((n & bitMask) == 0){
            System.out.println(n+" is even");
        }else{
            System.out.println(n+" is odd");
        }
    }

    //GET ITH BIT
    public static void getIthBit(int n, int i){
        int bitMask = 1<<i;

        if((n&bitMask)==0){
            System.out.println(i+"th bit is 0");
        }else{
            System.out.println(i+"th bit is 1");
        }
    }

    //SET ITH BIT TO 1
    public static void setIthBit(int n, int i){
        int bitMask = 1<<i;

        n = n|bitMask;
        System.out.println(n);
    }
    
    
    public static void clearLastIthBits(int n, int i){
      int bitMask = ~(0)<<i;
      
      n = n&bitMask;
      System.out.println(n);
    }

    public static void main(String[] args){
        System.out.println("WELCOMETO BITMANUPULATIONS");

        evenOrOdd(3);
        evenOrOdd(4);

        getIthBit(3,2);
        getIthBit(4, 2);

        setIthBit(3,2);
        setIthBit(4,3);
        
        clearLastIthBits(1,1);
        clearLastIthBits(7,1);

    }
}