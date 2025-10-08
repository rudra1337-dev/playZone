import java.util.*;
public class StringP {
    
    public static void isAnagram(String s1, String s2){
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        
        if(s1.length() != s2.length()){
            System.out.println("These are not Anagram strings");
            return;
        }
        
        Arrays.sort(a1);
        Arrays.sort(a2);
        if(Arrays.equals(a1,a2)){
            System.out.println("These are Anagram strings");
        }else System.out.println("These are not Anagram strings");
    }
    
    
    
    
    public static void main(String[] args) {
        String str = "role";
        String str1 = "eolr";
        
        isAnagram(str, str1);
        
    }
    
}


