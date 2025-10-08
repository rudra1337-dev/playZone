
public class Store {
    
}





  import java.util.Scanner;

public class Practice {
    
    public static void main(String args[]){
        /*1.
         Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int sum = a+b;
        System.out.printf("sum = a+b = %d",sum );
         */
        
        
        
        
        
        /*2.
         Scanner sc = new Scanner(System.in);
        
        System.out.printf("Enter a number here: ");
        int num = sc.nextInt();
        
        if(num%2==0){
            System.out.printf("The number %d is divisible by 2.",num);
        }else{
            System.out.printf("The number %d is not divisibleby 2.",num);
         }
        */
        
        
        
        /*3.
         Scanner sc = new Scanner(System.in);
        
        System.out.printf("Enter a number: ");
        int n = sc.nextInt();
        
        for(int i=0;i<=n;i++){
            System.out.printf("%d, ",i);
        }
        
        int i = 1;
        while(i<=n){
            System.out.printf("%d, ",i);
            i++;
        }
        
        int j = 1;
        do{
            System.out.printf("%d, ",j);
            j++;
        }while(j<=n);
         */
        
        
        
        /*4.
         for(int i = 1; i<=4; i++){
            for(int j = 1; j<=i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
         */
        
    }
    
}
 








import java.util.*;

public class Practice {
    
    public static int sum(int num){
        if(num ==0) return num;
        return ((num%10)+sum(num/10));
    }
    
    public static int fib(int num){
        if(num ==1 || num == 2) return 1;
        return (fib(num-2)+fib(num-1));
    }
    
    public static boolean prime(int num,int i){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % i == 0) return false;
        if(i*i > num) return true;
        return prime(num,i+1);
    }
    
    public static void print(int i, int j){
        System.out.print("*");
        j--;
        if(j<=0){
            i--;
            j=i;
            System.out.println();
        }
        if(i<=0 && j<=0) return;
        print(i,j);
            
    }
    public static void main(String args[]){
        /*1.
         Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.printf("Sum = %d",sum(num));
         */
    
        
        /*2.
         Scanner sc = new Scanner(System.in);
        System.out.printf("Entr a number: ");
        int num = sc.nextInt();
        
        System.out.printf("Fibonachhi of %d is %d",num,fib(num));
         */
        
        
        /*3.
         Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int num = sc.nextInt();
        System.out.printf("%d is a prime number: %B",num,prime(num,2));
         */
        
        
        
        //4.  print(4,4);
        
        
    }
}










import java.util.*;

public class Practice {
    
    public static int fib(int num){
        if(num == 1 || num == 2) return 1;
        return (fib(num-1)+fib(num-2));
    }
    
    public static void printPairs(int[] arr,int i,int j){
        System.out.printf("(%d,%d)",arr[i],arr[j]);
        if(i>=arr.length-1 && j>=arr.length-1) return;
        j++;
        if(j>=arr.length){
            i++;
            j = 0;
        }
        
        printPairs(arr,i,j);
    }
    
    public static void main(String args[]){
        
        /*1.
         for(int i=0; i<5; i++) System.out.printf("%d, ",i);
        //Time Complexity = O(n)
        //Space Complexity = O(1)
         
        
        for(int i=0; i<=5; i++){
            for(int j=0; j<=5; j++) System.out.printf("(%d,%d)",i,j);
        }
        //Time Complexity = O(n*n)
        //Space Complexity = O(2)
        
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("Fibonachhi of %d is %d",num,fib(num));
        //Time Complexity = O(n^n)
        //Space Complexity = O(n^n)
        */
        
        
        /*
         int[] arr = {1,2,3,4,5};
        printPairs(arr,0,0);
        //Time Complexity = O(n*n)
        //Space Complexity = O((n+2)*n)
         */
        
    }
}

import java.util.*;

public class Practice {
    
    public static void mergeSort(int[] arr,int start,int end){
        if(start < end){
            int mid = start+((end-start)/2);
            
            //For lef arr
            mergeSort(arr, start, mid);
            //for right arr
            mergeSort(arr, mid+1,end);
            
            merge(arr, start, mid, end);
        }
    }
    
    public static void merge(int[] arr, int st, int mid, int end){
        int i = st, j = mid+1, k = 0;
        int[] temp = new int[end-st+1];
        
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        
        //Copy the left part
        while(i<=mid) temp[k++] = arr[i++];
        while(j<=end) temp[k++] = arr[j++];
        
        //Copy to the original arr
        for(int x=0; x<=temp.length-1; x++){
            arr[st+x] = temp[x];
        }
    }
    
    public static void main(String args[]){
        
        /*3.
         int[] arr = {3,4,2,5,1};
        mergeSort(arr,0,arr.length-1);
        //Time Complexity = O
        
        for(int i=0; i<=arr.length-1;  i++){
            System.out.printf("%d, " ,arr[i]);
        }
         */
        
    }
}











import java.util.*;

public class Practice {
    
    
    
    public static void main(String args[]){
        
        //1.
        for(int i = 1; i<=5; i++){
            for(int j= 1; j<=4; j++) System.out.print("*");
            System.out.println();
        }
        
        //2.
        int n=4;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++) System.out.print("*");
            System.out.println();
        }
        
        //3.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++) System.out.print(" ");
            for(int k=1; k<=i; k++) System.out.print("*");
            System.out.println();
        }
        
        //4.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++) System.out.print(j);
            System.out.println();
        }
        
    }
}









//Arrays



import java.util.*;

public class Practice {
    
    
    
    public static void main(String args[]){
        
        //1.
        int[] arr = {1,2,3,4,5,6};
        for(int i=0; i<=arr.length-1; i++){
            System.out.printf("%d, ",arr[i]);
        }
        
        //2.
        int[] arr1 = new int[7];
        arr1[0]=0;
        arr1[1]=1;
        arr1[2]=2;
        arr1[3]=3;
        arr1[4]=4;
        
        int ind = 1;
        int num = 444;
        int size = 5;
        
        for(int i=size; i>=ind+1; i--){
            arr1[i] = arr1[i-1];
        }
        arr1[ind] = num;
        size++;
        
        for(int i=0; i<=arr1.length-1; i++){
            System.out.printf("%d, ",arr1[i]);
        }
        
        
        //3.
        int[] arr2 = {0,1,2,3,4,5,6};
        int idx = 2;
        for(int i=idx; i<=arr.length-1; i++){
            arr2[i] = arr2[i+1];
        }
        
        for(int i=0; i<=arr.length-1; i++){
            System.out.printf("%d, ",arr2[i]);
        }
        
    }
}

 









import java.util.*;

public class Practice {
    public static void printArr(int[] arr){
        for(int i=0; i<=arr.length-1; i++){
            System.out.printf("%d, ",arr[i]);
        }
    }
    
    public static void bubbleShort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=1; j<=arr.length-1-i; j++){
                if(arr[j-1]>=arr[j]){
                    arr[j-1] += arr[j];
                    arr[j] = arr[j-1]-arr[j];
                    arr[j-1] -= arr[j];
                }
                printArr(arr);
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public static void selectionShort(int[] arr){
        for(int i=0; i<=arr.length-2; i++){
            int mIdx = i;
            for(int j=i; j<=arr.length-2; j++){
                if(arr[mIdx]>=arr[j+1]){
                    mIdx = j+1;
                }
            }
            //Swaping
            arr[mIdx] += arr[i];
            arr[i] = arr[mIdx] - arr[i];
            arr[mIdx] -= arr[i];
            printArr(arr);
            System.out.println();
        }
    }
    
    public static void insertionSort(int[] arr){
        for(int i=1; i<=arr.length-1; i++){
            int temp = arr[i];
            int j = 0;
            for(j=i-1; (j>=0 && arr[j]>temp); j--){
                arr[j+1] = arr[j];
            }
        arr[j+1] = temp;
        }
    }
    
     public static void counterSort(int[] arr){
         int heighest = Integer.MIN_VALUE;
         for(int i=0; i<=arr.length-1; i++){
             heighest = Math.max(heighest ,arr[i]);
         }
         int[] pre = new int[heighest+1];
         for(int i=0; i<=arr.length-1; i++){
             pre[arr[i]]++;
         }
         int j=0;
         for(int i=0; i<=pre.length-1; i++){
             while(pre[i]>0){
                 arr[j] = i;
                 j++;
                 pre[i]--;
             }
         }
     }
    
    public static void linearSearch(int[] arr, int key){
        for(int i=0; i<=arr.length-1; i++){
            if(arr[i]==key) System.out.printf("Index of %d is %d",key,i);
        }
    }
    
    public static void binarySearch(int[] arr,int key){
        int st=0, end=arr.length-1;
        while(st<=end){
            int mid = st+((end-st)/2);
            if(arr[mid]==key){
                System.out.printf("Index of %d is %d",key,mid);
            }
            if(arr[mid]>key){
                end = mid-1;
            }else st= mid+1;
        }
        if(st>=end) return;
        System.out.printf("The number %d is not found.",key);
        
    }
    
    public static void main(String args[]){
        int[] arr = {4,5,8,2,4,3,1};
        
        //bubbleShort(arr);
        //TC = O(n^2)
        //SC = O(1)
        
        //selectionShort(arr);
        //TC = O(n^2)
        //SC = O(1)
        
        //insertionSort(arr);
        //TC = O(n^2)
        //SC = O(1)
        
        counterSort(arr);
        printArr(arr);
        
        
        
        binarySearch(arr,4);
       // linearSearch(arr,8);
        
        
        
        
    }
}












import java.util.*;

public class Practice {
    public static void printArr(int[] arr){
        for(int i=0; i<=arr.length-1; i++){
            System.out.printf("%d, ",arr[i]);
        }
    }
    
    public static void maxSubArrSum(int[] arr){
        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i<=arr.length-1; i++){
            for(int j=i; j<=arr.length-1; j++){
                int currSum=0;
                for(int k=i; k<=j; k++){
                    currSum+=arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.printf("Maximum sub array sum is %d.",maxSum);
    }
    
    
    public static void prefix(int[] arr){
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i=1; i<=arr.length-1; i++){
            pre[i] = pre[i-1] + arr[i];
        }
        
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<=arr.length-1; i++){
            int currSum = 0;
            for(int j=i; j<=arr.length-1; j++){
                currSum = i==0 ? pre[0] : pre[j]-pre[i-1];
                maxSum = Math.max(maxSum,currSum);
            }
        }
        System.out.printf("Maimum Sub array sum is %d.",maxSum);
    }
    
    
    
    
    public static void kedni(int[] arr){
        String type = "";
        int typ = -1;
        for(int i=0; i<=arr.length-1; i++){
            if(arr[i]>=0) typ++;
        }
        
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0; i<=arr.length-1; i++){
            currSum+=arr[i];
            if(currSum<0 && typ>=0){
                currSum=0;
            }else if(currSum>0 && typ<0){
                currSum=0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.printf("Maximum sub array sum is %d.",maxSum);
    }
    
    public static void main(String args[]){
        int[] arr = {-1,-4,-6,3,4,-4,8};
        
               
        maxSubArrSum(arr);
        
        prefix(arr);
        
        kedni(arr);
        
    }
}