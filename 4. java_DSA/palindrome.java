// words that read both forward and backwards eg madam, racecar, 121,
// write a function that checks wether a given string is a palindrome
// - declare the word  - string
// - loop thru forward the array and record finding
// - check if the indexes match against another backword loop of the same array
// - left = 0 and right = i.length()-1
// - madam
// - madam
// letters from right should match letters from  left

public class Palindrome{
    public static Boolean isPalindrome(String input) {
        int[] left = 0;
        int[] right = input.lenght() -1;
        while(left < right) {
            if(input.CharAt(left) != input.CharAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        String word = "madam";
        Boolean result = isPalindrome(word);
        System.out.println(result);
    }
}

// with edgecases 

// words that read both forward and backwards eg madam, racecar, 121,
// write a function that checks wether a given string is a palindrome
// - declare the word  - string
// - loop thru forward the array and record finding
// - check if the indexes match against another backword loop of the same array
// - left = 0 and right = i.length()-1
// - madam
// - madam
// letters from right should match letters from  left

public class palindrome {
public static String isPaString(String input) {
    int[] right = 0;
    int[] left = input.length() -1;
    while(input.charAt(right) != input.charAt(left)){
        return false;
        right++;
        left++;
    }
    return true;

}
}