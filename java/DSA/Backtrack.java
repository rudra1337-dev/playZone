

 class Backtrack{
   
   public static void printArr(int[] arr){
     System.out.print("Arr : ");
     for(int num : arr) System.out.print(num+",");
   }
   
   public static void changeArr(int[] arr, int idx, int val){
     //1 base case
     if(idx==arr.length){
       printArr(arr);
       return;
     }
    
    //2 work
    arr[idx] = val;
    changeArr(arr, idx+1, val+1);
    //dexrease to -2
    arr[idx] = val-2;
   }
   
   
   public static void findSubset(String str, int i, StringBuilder sb){
     //base case
     if(i == str.length()){
       if(sb.length()==0){
         System.out.println("null");
       }else{
         System.out.println(sb.toString()+",");
       }
       return;
     }
     
     
     //work
     //yes included
     sb.append(str.charAt(i));
     //go included
     findSubset(str, i+1, sb);
     //backtrack and No
     sb.deleteCharAt(sb.length()-1);
     //not included
     findSubset(str, i+1, sb);
   }
  
  
  public static void main(String args[]){
    System.out.println("WELCOME TO BACKTRACKING");
    
    int[] arr = new int[5];
    changeArr(arr, 0, 1);
    printArr(arr);
    
    
    StringBuilder sb = new StringBuilder();
    findSubset("abc", 0, sb);
  }
}