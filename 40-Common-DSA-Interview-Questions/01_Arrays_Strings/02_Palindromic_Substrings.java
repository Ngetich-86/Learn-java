// words that read both forward and backwards eg madam, racecar, 121,
// write a function that checks wether a given string is a palindrome
// - declare the word  - string
// - loop thru forward the array and record finding
// - check if the indexes match against another backword loop of the same array
// - left = 0 and right = i.length()-1
// - madam
// - madam
// letters from right should match letters from  left

class IsPalindrome {
    public static Boolean isPalindrome(String input){
        int[] left = 0;
        int[] right = input.length() - 1;
        while(left < right){
            if(input.char(right) != input.char(left)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        String input = "madam";
        Boolean result = isPalindrome(input);
        System.out.Println(result);
    }
}