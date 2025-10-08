import java.util.*;

public class ex{

//Given an array check it containns duplicate or not  
public static boolean checkDuplicate(int[] arr){  
    HashSet<Integer> set = new HashSet<>();  
      
    for(int i : arr){  
        if(set.contains(i)){  
            return true;  
        }  
        set.add(i);  
    }  
    return false;  
}  
  
//Count how many times each elements occur  
public static void frequency(int[] arr){  
    HashMap<Integer,Integer> fre = new HashMap<>();  
      
    for(int i : arr){  
        fre.put(i, fre.getOrDefault(i, 0)+1);  
    }  
    System.out.println(fre);  
}  
  
  
//Given a array of numbers and find the first non repeating number  
public static void checkRepeat(String str){  
      
    char[] ch = str.toCharArray();  
    HashMap<Character, Integer> fre = new HashMap<>();  
      
    for(char s : ch){  
        fre.put(s, fre.getOrDefault(s,0)+1);  
    }  
      
    for(char c : fre.keySet()){  
        if(fre.get(c) == 1){  
            System.out.println("The first non repeating number = "+c);  
            return;  
        }  
    }  
    System.out.println("Here no repeating elements present");  
}  
  
  
//Problem: Find union and intersection  
public static void ui(int[] arr1, int[] arr2){  
    HashSet<Integer> union = new HashSet<>();  
    HashSet<Integer> intersection = new HashSet<>();  
      
    for(int num : arr1) union.add(num);  
    for(int num : arr2){  
        if(union.contains(num)){  
            intersection.add(num);  
        }  
        union.add(num);  
    }  
      
    System.out.println("Union = "+union);  
    System.out.println("Intersection = "+intersection);  
}  
public static void main(String[] args) {  
    int[] arr = {1,2,3,5,4,1,5};  
      
    //System.out.println(checkDuplicate(arr));  
    //frequency(arr);  
    //checkRepeat("bananyba");  
    int arr1[] = {1,2,3,4};  
    int arr2[] = {3,4,5,6};  
    ui(arr1,arr2);  
}

}