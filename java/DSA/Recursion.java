


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




  //Divide and concure 
  //merge sort and quick sort is completed on array chapter
  //this is sorted and roted array
  public static int sortedAndRoted(int arr[], int target, int st, int end){
    if(st > end) return -1;

    int mid = st+(end-st)/2;

    //base case
    if(arr[mid] == target) return mid;
    

    //work
    //L1 case
    if(arr[st] <= arr[mid]){
      //case L1 left
      if(arr[st] <= target && target <= arr[mid]){
        return sortedAndRoted(arr, target, st, mid-1);

        //case L1 right + l2
      }else{
        return sortedAndRoted(arr, target, mid+1, end);
      }
    }

    //L2 case
    //if(arr[mid] <= arr[end]){
    else{
      //case R1 right
      if(arr[mid] >= target && target >= arr[end]){
        return sortedAndRoted(arr, target, mid+1, end);

        //case L2 left + L1
      }else{
        return sortedAndRoted(arr, target, st, mid-1);
      }
    }

  }


  //loop method of sortedRoted problem
  public static int sortedAndRoted1(int[] arr, int target, int st, int end){

    while(!(st>end)){

      int mid = st+(end-st)/2;

      //base case
      if(arr[mid] == target) return mid;
      
      //L1 case
      if(arr[st]<=arr[mid]){
        //case a L1 left
        if(arr[st] <= target && target <= arr[mid]){
          //st = st;
          end = mid-1;

          //case b l1 left + L2
        }else{
          st = mid+1;
          //end = end;
        }


        //L2 case
      }else{ // if(arr[mid]<=arr[end])

        //case L2 right
        if(arr[mid]<=target && target<=arr[end]){
        st = mid+1;
        //end = end;
        }else{
          //case L2 left + L1
          //st = st;
          end = mid-1;
        }
      }
    }

    return -1;
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



    int arr[] = {4,5,6,7,0,2};
    System.out.println("O is present at "+sortedAndRoted(arr, 0, 0, arr.length-1)+"th position");
    System.out.println("4 is present at "+sortedAndRoted(arr, 4, 0, arr.length-1)+"th position");
    System.out.println("5 is present at "+sortedAndRoted(arr, 5, 0, arr.length-1)+"th position");



    System.out.println("O is present at "+sortedAndRoted1(arr, 0, 0, arr.length-1)+"th position");
    System.out.println("4 is present at "+sortedAndRoted1(arr, 4, 0, arr.length-1)+"th position");
    System.out.println("5 is present at "+sortedAndRoted1(arr, 5, 0, arr.length-1)+"th position");

  }
  
}