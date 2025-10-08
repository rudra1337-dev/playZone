class hello{
    public static void printArr(int[] arr){
        for(int num : arr) System.out.printf("%d, ",num);
        System.out.println();
    }
    
    
    public static void selrction(int[] arr){
        
        for(int i=1; i<=arr.length-1; i++){
            int temp = arr[i];
            int j=0;
            for(j=i-1; j>=0 && temp<=arr[j]; j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=temp;
        }
    }
    
    
    
    public static void main(String[] args){
        
        // Method 2: Direct initialization
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int arr[]  = {4,2,6,1,-5,1,-2};
        printArr(arr);
        selrction(arr);
        printArr(arr);
    }
}