    
import java.util.*;

public class Practice {
    public static void printArr(int[] arr){
        for(int i=0; i<=arr.length-1; i++){
            System.out.printf("%d, ",arr[i]);
        }
    }
    
    public static void mergeSort(int[] arr, int start, int end){
        int mid = start + ((end-start)/2);
        if(start>=end) return;
        
        //Calling left
        mergeSort(arr,start,mid);
        //Calling right
        mergeSort(arr,mid+1,end);
        
        //Calling to merge
        merge(arr,start,mid,end);
    }
    
    public static void merge(int[] arr, int start, int mid, int end){
        int i=start, j=mid-1, k=0;
        int[] temp = new int[end-start];
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
            
            while(i<=mid) temp[k++]=arr[i++];
            while(j<=end) temp[k++]=arr[j++];
            
            for(int x=start; x<=end; x++){
                arr[i]=temp[i];
            }
        }
    }
    public static void main(String args[]){
        int[] arr = {-1,-4,-6,3,4,-4,8};
        
        mergeSort(arr,0,arr.length-1);
               printArr(arr);
        
        
    }
}