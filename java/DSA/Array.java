import java.util.*;
public class Array{
    public static  String linearSearch(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                
                return ("The number "+key+" is found at "+i+"th index");
            }
        }
        return ("The number "+key+" is not found");
    }
    
    public static  int largestNoOfArr(int arr[]){
        int large=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(large<=arr[i]){
                large=arr[i];
            }
        }
        return large;
    }
    
    public static  int smallestNoOfArr(int arr[]){
        int large=Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(large>=arr[i]){
                large=arr[i];
            }
        }
        return large;
    }
    
    public static String binarySearch(int arr[], int key){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return ("The number "+key+" is found at "+mid+"th index"); 
            }
            if(arr[mid]<key){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ("The number "+key+" is not found");
    }
    
    public static void revArr(int arr[]){
        int last=arr.length-1;
        for(int i=0; i<=last; i++){
            arr[i]+=arr[last];
            arr[last]=arr[i]-arr[last];
            arr[i]=arr[i]-arr[last];
            last--;
        }   
    }
    
    public static void printArr(int arr[]){
        for(int i=0; i<=(arr.length-1); i++){
            System.out.print(arr[i]+",");
        }
    } 
    
    public static void printPairs(int arr[]){
        for(int i=0; i<=(arr.length-1); i++){
            for(int j=i; j<=(arr.length-1); j++){
                System.out.printf("(%d,%d)",arr[i],arr[j]);
            }
            System.out.println();
        }
    }
    
    public static void printSubArr(int arr[]){
        for(int i=0; i<=(arr.length-1); i++){
            for(int j=i; j<=(arr.length-1); j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public static void maxSubArrSum(int arr[]){
        int sum=Integer.MIN_VALUE;
        for(int i=0; i<=(arr.length-1); i++){
            for(int j=i; j<=(arr.length-1); j++){
                int temp=0;
                for(int k=i; k<=j; k++){
                    temp+=arr[k];
                }
                if(temp>=sum){
                        sum=temp;
                    }
            }
        }
        System.out.print(sum);
    }
    
    public static void maxSubArrSumPrefix(int arr[]){
        int prefix[]= new int[arr.length];
        prefix[0]=arr[0];
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=1; i<=(arr.length-1); i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        for(int i=0; i<=(arr.length-1); i++){
            int start=i;
            currentSum=0;
            for(int j=i; j<=(arr.length-1); j++){
                int end=j;
                currentSum+=arr[j];
                
                if(currentSum>=maxSum){
                    maxSum= start==0 ? prefix[end] : prefix[end]-prefix[start-1];
                }
            }
        }
        System.out.print(maxSum);
    }
    
    public static void godanceAlgorithm(int arr[]){
        int curSum=0;
        int maxSum= Integer.MIN_VALUE;
        
        for(int i=0; i<=(arr.length-1); i++){
            curSum+=arr[i];
            if(curSum<=0){
                curSum=0;
            }
            if(curSum>=maxSum){
                maxSum=curSum;
            }
        }
        System.out.print(maxSum);
    }
    
    public static void main(String args[]){
        //Scanner s= new Scanner(System.in); 
        //System.out.print("Entr a number to search:");
        //int n= s.nextInt();
        int numbers[] = {-10,-1,-2,-3};
        //System.out.print(linearSearch(numbers,n));
        //System.out.print(binarySearch(numbers,n));
        
        
        //ReverseArray
      /*  printArr(numbers);
        revArr(numbers);
        printArr(numbers);
      */
        
        
        //printPairs(numbers);
        
       // printSubArr(numbers);
        
        //maxSubArrSum(numbers);
        //maxSubArrSumPrefix(numbers);
        //godanceAlgorithm(numbers);
        
        //System.out.print(largestNoOfArr(numbers));
        //System.out.print(smallestNoOfArr(numbers));
    }
}