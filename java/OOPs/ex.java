




public class ex{
  
  public static void printArr(int[] arr){
  for(int num : arr){
    System.out.printf("%d, ",num);
  }
}
  
  
  public static void bubbleSort(int arr[]){
    for(int i=0; i<=arr.length-2; i++){
      for(int j=0; j<arr.length-1-i; j++){
        if(arr[j]>=arr[j+1]){
          arr[j]+=arr[j+1];
          arr[j+1]=arr[j]-arr[j+1];
          arr[j]=arr[j]-arr[j+1];
        }
      }
    }
  }

  
  public static void selectionSort(int[] arr){
    for(int i=0; i<=arr.length-2; i++){
      int mInd = i;
      for(int j=i; j<=arr.length-2; j++){
        if(arr[mInd]>=arr[j+1]){
          mInd = j+1;
        }
      }
      int temp = arr[mInd];
        arr[mInd] = arr[i];
        arr[i] = temp;
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
  
  
  public static void countSort(int[] arr){
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for(int i=0; i<=arr.length-1; i++){
      min = Math.min(min,arr[i]);
      max = Math.max(max,arr[i]);
    }
    
    int range = max-min+1;
    int[] fre = new int[range];
    for(int i=0; i<=arr.length-1; i++){
      fre[arr[i]-min]++;
    }
    
    int index=0;
    for(int i=0; i<=fre.length-1; i++){
      while(fre[i]>0){
        arr[index++] = i+min;
        fre[i]--;
      }
    }
  }
  
  
  public static void mergeSort(int[] arr, int stI, int endI ){
    if(stI>=endI) return;
    int mid = stI + ((endI-stI)/2);
    
    //left
    mergeSort(arr, stI, mid);
    //right
    mergeSort(arr, mid+1, endI);
    
    merge(arr, stI, mid, endI);
  }
  
  
  public static void merge(int[] arr, int stI, int mid, int endI){
    int i= stI, j= mid+1, k=0;
    int[] temp = new int[endI-stI+1];
    
    while(i<=mid && j<=endI){
      if(arr[i]>=arr[j]){
        temp[k++] = arr[j++];
      }else{
        temp[k++] = arr[i++];
      }
    }
    
    while(i<=mid) temp[k++] = arr[i++];
    while(j<=endI) temp[k++] = arr[j++];
    
    for(k=0; k<=temp.length-1; k++){
      arr[k+stI] = temp[k];
    }
  }
  
  
  public static void quickSort(int arr[], int stI, int endI){
    if(stI>=endI) return;
    int mid = partision(arr, stI, endI);
    
    //left
    quickSort(arr, stI, mid-1);
    quickSort(arr, mid+1, endI);
  }
  
  public static int partision(int arr[], int stI, int endI){
    int piv = arr[endI];
    int i=stI-1, j=stI;
    
    while(j<=(endI)){
      if(arr[j]<=piv){
        i++;
        int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
      }
      j++;
    }
    
    return i;
  }
  
  public static void prefixSum(int arr[]){
    int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
    int[] pre = new int[arr.length];
    pre[0] = arr[0];
    for(int i =1; i<=arr.length-1; i++){
      pre[i] = pre[i-1]+arr[i];
    }
    
    for(int i=0; i<=arr.length-1; i++){
      int end = i;
      for(int j=0; j<=i; j++){
        int start = j;
        int currSum = start==0 ? pre[end] : pre[end]-pre[start-1];
        maxSum = Math.max(maxSum, currSum);
        minSum = Math.min(minSum, currSum);
      }
    }
    
    System.out.println("Max Sum = "+maxSum+" Min Sum = "+minSum);
  }
  
  
  public static void kadanesAlgo(int[] arr){
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int i=0; i<=arr.length-1; i++){
      currSum += arr[i];
      maxSum = Math.max(maxSum,currSum);
      if(currSum<0){
        currSum=0;
      }
    }
    System.out.println("Max Sum = "+maxSum);
  }
    public static void main(String[] args){
      int[] arr = {3,2,-3,87,9,8,-29,2,2};
      printArr(arr);
      System.out.println();
      //bubbleSort(arr);
      //selectionSort(arr);
      //insertionSort(arr);
      //countSort(arr);
      //mergeSort(arr, 0, arr.length-1);
      //quickSort(arr, 0, arr.length-1);
      printArr(arr);
      
      
      //SUB array sum
      
      //prefixSum(arr);
      kadanesAlgo(arr);
      
    }
}