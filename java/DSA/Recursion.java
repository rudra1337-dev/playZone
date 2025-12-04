


public class Recursion{
  
  public static void printNto1(int n){
    System.out.println("DEBUG n = " + n);   // 👈 ADD THIS

    if(n == 1){
        System.out.print(n + ",");
        return;
    }

    System.out.print(n + ",");
    printNto1(n - 1);
}

public static void print1toN(int n){
  if(n == 0){
    return;
  }
  
  print1toN(n-1);
  System.out.println(n+",");
}

public static int factorial(int n){
  if(n==1 || n==0) return 1;
  
  return n*factorial(n-1);
}

public static int printSumOfNnatu(int n){
  if(n == 1) return 1;
  
  return n+printSumOfNnatu(n-1);
}


public static int fibonachhie(int n){
  if(n==1) return 1;
  if(n==0) return 0;
  
  return fibonachhie(n-1)+fibonachhie(n-2);
}

  public static boolean isSorted(int[] arr, int st, int end){
    if(st >= (end-1)) return true;
    
    if(arr[st] > arr[st+1]) return false;
    
    return isSorted(arr, st+1, end);
  }
  
  
  public static int firstOccurance(int n, int[] arr, int st){
    if(st == arr.length-1) return -1;
    
    if(arr[st] == n) return st;
    return firstOccurance(n, arr, st+1);
  }
  
  
  public static int lastOccurance(int n, int[] arr, int end){
    if(end == 0) return -1;
    
    if(arr[end] == n) return end;
    return lastOccurance(n, arr, end-1);
  }
  
  
  public static int Pow(int n, int p){
    if(p==1) return n;
    
    return n*Pow(n, p-1);
  }// time complexity = O(n)
  
  
  public static int OptimizedPow(int n, int p){
    if(p == 0) return 1;
    
    int half = OptimizedPow( n, p/2);
    int power = half*half;
    
    //Odd case
    if(p%2  != 0) power *= n;
    
    return power;
  }
  

  public static int waysOfTiling(int n){
    //Base cases
    if(n==0 || n==1) return 1;
    if(n==2) return 2;

    return waysOfTiling(n-1)+waysOfTiling(n-2);
  }
  
  public static String removeDuplicates(String str, StringBuilder sb, int idx, boolean[] map){
    //base case
    if(idx == str.length()-1){
      System.out.println(sb);
      return sb.toString();
    }
    
    //checke is the char already exist
    char ch = str.charAt(idx);
    if(!(map[ch-'a']==true)){
      sb.append(ch);
    }
    
    //update the char map
    map[ch-'a'] = true;
    
    //recursion call
    return removeDuplicates(str, sb, idx+1, map);
  }




  //Friends pairing probem
  public static int wayToPair(int n){
    if(n==0 || n==1) return 1;
    if(n==2) return 2;

    int Wasyofsingle = wayToPair(n-1);
    int Waysofpair = wayToPair(n-2);

    int totalWays = Wasyofsingle + (n-1)*Waysofpair;

    return totalWays;
  }


  //IMp print binary string
  public static void printBinStrings(int n, int lp, String str){
    if(n == 0){
      System.out.println(str);
      return;
    }

    if(lp == 0){
      printBinStrings(n-1, 0, str+0); // for 0
      printBinStrings(n-1, 1, str+1); // fro 1
    }else{
      //for lp == 1 skip printing 1
      printBinStrings(n-1, 0, str+0); // only for 0
    }


  }
  
  
  public static void main(String args[]){
    System.out.println("WELCOME TO RECURSION");
    
    printNto1(10);
    print1toN(10);
    System.out.println("Factorial = "+factorial(10));
    System.out.println("Sum of n natural no ="+printSumOfNnatu(49));
    System.out.println("Fibonachhie ="+fibonachhie(10));
    
    int arr1[] = {1,3,4,6,7,7,7,8};
    int arr2[] = {1,3,4,6,7,9,7,8};
    System.out.println("Array is Sorted = "+isSorted(arr1, 0, arr1.length-1));
    System.out.println("Array is Sorted = "+isSorted(arr2, 0, arr2.length-1));
    
    int arr3[] = {1,4,3,5,8,8,5};
    System.out.println("First occurance of 5 = "+firstOccurance(5, arr3, 0));
    System.out.println("Last occurance of 8 = "+lastOccurance(8, arr3,
    arr3.length-1));
    
    System.out.println("5 to the power of 4 ="+Pow(5,4));
    System.out.println("5 to the power of 4 ="+OptimizedPow(5,4));
    
    boolean[] map = new boolean[26];
    StringBuilder sb = new StringBuilder();
    removeDuplicates("ruddraa", sb, 0, map);
    
    System.out.println("Ways of tiling = "+waysOfTiling(0));
    System.out.println("Ways of tiling = "+waysOfTiling(1));
    System.out.println("Ways of tiling = "+waysOfTiling(2));
    System.out.println("Ways of tiling = "+waysOfTiling(3));
    System.out.println("Ways of tiling = "+waysOfTiling(4));




    System.out.println("Ways to pair friends = "+wayToPair(3));

    printBinStrings(3, 0, "");


  }
  
}