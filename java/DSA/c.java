
public class c {
  
  public static void binary(int arr[], int k){
    int st=0, end=arr.length-1, mid= (st+end)/2;
    
    for(int i = 0; i<=arr.length-1; i++){
      if(arr[mid] == k){
      System.out.println(k+ " is found");
      return;
      }else if(arr[mid] > k){
        end = mid-1;
      }else if(arr[mid] < k){
        st = mid+1;
      }
    }
    System.out.println(k+" not found");
    
  }
    public static void main(String args[]){
      int[] arr = {1,4,6,8};
      binary(arr, 9);
    }
}