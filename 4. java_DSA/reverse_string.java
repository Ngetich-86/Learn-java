// input : hello
//outut: olleh
// pseudo code 


public class reverse_string {
    public static String reverse(String input){
        String reversed = "";
        for(int i = input.length() - 1;i >=0;i--){
            reversed += input.charAt(i);
        }
        return reversed;
    }
    public static void Main(String[] args){
        String word = "hello";
        String result = reverse(word);
        System.out.println(result);
    }
}

// ======================practise day 2
// input : hello
//outut: olleh

public class Innerreverse_string {
    public static String rveString(String input) {
        String reversed = "";
        // backward reverse
        for(int i = input.length() - 1; i > 0;i--) {
            // update reverse string to it reverse order now
            reversed += input.charAt(i);
        }
        return reversed;
    }
    public static void main(String[] args) {
        String word = "Hello";
        String result = rveString(word);
        for(int wordresult: result){
            System.out.println(wordresult);
        }

    }

    
}

// input : hello
//outut: olleh
public class Test{
    public static String reverserString(String input) {
        String reversed = "";
        // loop baeckwards and updte the reverse
        for(int i = input.length() -1; i > 0; i--) {
            // update reversed
            reversed += input.charAt(i);
        }
        return reversed;

    }
}