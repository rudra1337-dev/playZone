
public class Algorithms {
    
    public static void printArr(int arr[]){
        for(int i=0; i<=(arr.length-1); i++){
            System.out.print(arr[i]+",");
        }
    }
    
    public static void boobleShort(int arr[]){
        for(int i=0; i<=(arr.length-2); i++){
            for(int j=0; j<=(arr.length-2-i); j++){
                //Swaping
                if(arr[j]>arr[j+1]){
                    arr[j]+=arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]=arr[j]-arr[j+1];
                }
            }
        }
        printArr(arr);
    }
    
    public static void selectionShort(int arr[]){
        for(int i=0; i<=(arr.length-2); i++){
            int minPos=i;
            //unSortedArray
            for(int j=i+1; j<=(arr.length-1); j++){
                if(arr[minPos]>=arr[j]){
                    minPos=j;
                }
            }
            //swap
            arr[i]+=arr[minPos];
            arr[minPos]=arr[i]-arr[minPos];
            arr[i]=arr[i]-arr[minPos];
        }
        
        printArr(arr);
    }
    
    
    public static void insertionSort(int arr[]){
        for(int i=1; i<=(arr.length-1); i++){
            int pre=i-1,curr=arr[i];  //pre=0,curr=1  index
            while(pre>=0 && arr[pre]>curr){
                arr[pre+1]=arr[pre];
                pre--; //pre-1
            }
            arr[pre+1]=curr;
        }
        printArr(arr);
    }
    
    public static void countingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0; i<=(arr.length-1); i++){
            largest=Math.max(largest,arr[i]);
        }
        
        //frequence count
        int count[]= new int[largest+1];//+1 for zeroth index
        for(int i=0; i<=(arr.length-1); i++){
            count[arr[i]]++;
        }
        
        //sorting
        int j=0;
        for(int i=0; i<=(count.length-1); i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
            
        }
        printArr(arr);
    }
    
    public static void main(String[] args) {
        int arr[]={5,3,2,1,4};
        
        boobleShort(arr);
        //selectionShort(arr);
        //insertionSort(arr);
      //  countingSort(arr);
    }
    
}