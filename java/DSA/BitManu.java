
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

    //CLEAR ITH BIT
    public static void clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        n = n&bitMask;
        System.out.println(n);
    }



    //CLEAR I BITS FROM LAST
    public static void clearLastIthBits(int n, int i){
      int bitMask = ~(0)<<i;
      
      n = n&bitMask;
      System.out.println(n);
    }


    //UPDATE ITH BIT
    public static void updateIthBit(int n, int i, int bit){
        // //1st aproach
        // if(bit == 0){
        //     clearIthBit(n, i);
        // }else{
        //     //bit == 1
        //     setIthBit(n, i);
        // }

        //2nd aproach
        ////clear ith bit
        int bitmask = ~(1<<i);
        n = n&bitmask;

        ////set ith bit
        int bitMask = bit<<i;
        n = n|bitMask;
        System.out.println(n);

    }

    public static void clearBitsInRange(int n, int i, int j){
        //shifting to i
        int bitmask1 = (~0)<<i;//111111111111111111111000
        int bitmask2 = ~((~0)<<j);//000000000000000000001

        int a = bitmask1&n;//0000000000000000001000
        int b = bitmask2&n;//0000000000000000000001

        n = a|b;//00000000000000001001
        System.out.println(n);
    }


    public static void isPower(int n){
        int bitMask = n&(n-1);

        if(bitMask == 0){
            System.out.println(n+" is a power of 2");
        }else{
            System.out.println(n+" is not a power of 2");
        }
    }


    public static void countSetBits(int n){
        int num = n;
        int count = 0;
        int bitMask = 1;
        while(!(num==0)){
            if((num&bitMask)==1) count++;
            num = num>>1;
        }
        System.out.println(n+" has "+count+" set bits");
    }




    public static int fastExpo(int n, int p){
        int res = 1, a = n;

        while(!(p==0)){
            if((p&1)==1) res *= a;
            a *= a;
            p = p>>1;
        }

        System.out.println("Ans = "+res);
        return res;
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

        updateIthBit(6,2,0);
        updateIthBit(6,3,1);

        clearBitsInRange(15, 3, 1); //1111
        clearBitsInRange(10, 4, 2);

        isPower(16);
        isPower(10);;

        countSetBits(15);
        countSetBits(14);

        fastExpo(5,3);
        fastExpo(2, 4);
    }
}