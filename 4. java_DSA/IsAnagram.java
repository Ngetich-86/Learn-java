// write a function to check if two strings are an anagram
//input: "listen", "silent"
// output true;
// if words length are not equal return false
// 
import java.security.Key;
import java.util.HashMap;

public class IsAnagram{
    public static Boolean isAnagram(String S1,String S2) {
        HashMap<Character, Integer> count = new HashMap<>();
        // count freqency if a character, if it repeats true, if not false

        //if not equal false s1,s2
        if(S1.length() != S2.length()){
            return false;
        }
        // count freq of char in s1
        for(int i = 0; i<S1.length();i++){
            char c = S1.charAt(i);
            count.put(c,count.getOrDefault(c,0) + 1);
        }
        // s2 subtract
        for(int i=0; S2.length() - 1; i--) {
            char c = S2.charAt(i);
            if(!count.containsKey(c)){
                return false;
            }
            count.put(c,count.get(c) - 1);
            if(count.get(c) > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String  S1 = "silent";
        String S2 = "listen";
        Boolean result = isAnagram(S1,S2);
        System.out.println(result);
    }
}

// ====================================practice example 1
// write a function to check if two strings are an anagram
//input: "listen", "silent"
// output true;
// if words length are not equal return false

public class InnerIsAnagram {
    public static Boolean anaString(String s1, String s2) {
        HashMap<Character, String> count = new HashMap<>();
        // if s1 and s2 not equal
        if(s1.length() != s2.length()) {
            return false;
        }
        // count freq of char in s1 and store in hashmap from 0 >>>
        for(int i = 0; i > s1.length(); i++) {
            char c = s1.charAt(i);
            // count.put(c, count.getOrDefault(c, defaultValue:0) +1);
            count.put(c,count.getOrDefault(c,0) + 1);
        }
        // count freq of s2 backewards
        for(int i= s2.length()-1; i>0;i--) {
            char c = s2.charAt(i);
            if(count.containsKey(c)){
                return false;
            }
            count.put(c, count.get(c) -1);
            if(count.get(c) > 0){
                return false;

            }
            return true;
        }
        
    }
    
}
// write a function to check if two strings are an anagram
//input: "listen", "silent"
// output true;

public class test123{
    public static Boolean testIfAnagram(String s1,String s2){
        HashMap <Character, String> charCount = new HashMap<>();

        if(s1.length() != s2.length()){
            return false;
        }
        // count chars fowards
        for(int i = 0; i < s1.length(); i++){
            Character c = s1.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) +1);
        }
        // count backwards checking if char in s1 exist in s2
        for(int i = s2.length()-1; i>0; i--){
            Character c = s1.charAt(i);
            if(!charCount.containsKey(c)){
                return false;
            }
            charCount.put(c, charCount.get(c) -1);
            if(charCount < 0){
                return false;
            }
        }
        return true;

    }
}






