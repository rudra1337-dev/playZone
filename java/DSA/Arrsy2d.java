
public class Arrsy2d {
    
    //SPIRAL TAVERSE
    public static void spiral(int[][] arr){
        int sr=0,sc=0;
        int er=arr.length-1,ec=arr[0].length-1;
        
        while(sr<=er && sc<=ec){
            //top
            for(int j=sc; j<=ec; j++){
                System.out.printf("%d,",arr[sr][j]);
            }
            
            //right
            for(int i=sr+1; i<=er; i++){
                System.out.printf("%d,",arr[i][ec]);
            }
            
            //bottom
            for(int j=ec-1; j>=sc; j--){
                if(ec==sc){
                    break;
                }
                System.out.printf("%d,",arr[er][j]);
            }
            
            //left
            for(int i=er-1; i>=sr+1; i--){
                if(er==sr){
                    break;
                }
                System.out.printf("%d,",arr[i][sc]);
            }
            
            sr++;
            sc++;
            er--;
            ec--;
        }
        
    }
    
    public static void printArr(int arr[][]){
        for(int i[]:arr){
            for(int num : i){
                System.out.print(num+",");
            }
            System.out.println();
        }
    }
    
    
    
    
    //SUM OF DIAGONAL
    public static void diagonalSum(int[][] arr){
        int sum=0;
        
        for(int i=0; i<=arr.length-1; i++){
            for(int j=0; j<=arr[i].length-1; j++){
                if(i==j){
                    sum+=arr[i][j];
                    //System.out.println(arr[i][j]);
                }else if(i+j==arr.length-1){
                    sum+=arr[i][j];
                //System.out.println(arr[i][j]);
                }
            }
        }
        System.out.print(sum);
    }
    
    public static void diagonalsum(int[][] arr){
        int sum=0;
        for(int i=0; i<=arr.length-1; i++){
            sum+=arr[i][i];
            //System.out.printf("(%d,%d)",i,i);
            if(i != arr[i].length-1-i){
                
                //System.out.printf("(%d,%d)",i,arr[i].length-1-i);
                sum+=arr[i][arr[i].length-1-i];
            }
            
        }
        System.out.print(sum);
    }
    
    
    
    
    //SEARCHING IN 2D ARRAY
    public static boolean search(int[][] arr, int key){
        for(int i=0; i<=arr.length-1; i++){
            for(int j=0; j<=arr[i].length-1; j++){
                if(arr[i][j]==key){
                    System.out.print("The number "+key+" is found at index ["+i+"]["+j+"].");
                    return true;
                }
            }
        }
        System.out.print("The number "+key+" is not found.");
        return false;
    }
    
    public static boolean searchBin(int[][] arr, int key){
        
        for(int i=0; i<=arr.length-1; i++){
            int start=0, end=arr[i].length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[i][mid]==key){
                    System.out.print("The number "+key+" is found at index ["+i+"]["+mid+"].");
                    return true;
                }
                
                if(key>arr[i][mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        System.out.print("The number "+key+" is not found.");
        return false;
    }
    
    public static boolean stearSearch(int[][] arr, int key){
        int row=0, col=arr[0].length-1;
        
        while(row<=arr.length-1 && col>=0){
            if(arr[row][col]==key){
                System.out.print("The number "+key+" is found at index ["+row+"]["+col+"].");
                    return true;
            }else if(arr[row][col]<key){
                row++;
            }else{
                col--;
            }
        }
        System.out.print("The number "+key+" is not found.");
        return false;
    }
    
    public static boolean stearSearch1(int[][] arr, int key){
        int row=arr.length-1, col=0;
        while(row>=0 && col<=arr[0].length-1){
            if(arr[row][col]==key){
                System.out.print("The number "+key+" is found at index ["+row+"]["+col+"].");
                return true;
            }else if(arr[row][col]>key){
                row--;
            }else{
                col++;
            }
        }
        System.out.print("The number "+key+" is not found.");
        return false;
    }
    
    public static void main(String args[]){
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        
        printArr(matrix);
        System.out.println();
        spiral(matrix);
    }
    
}