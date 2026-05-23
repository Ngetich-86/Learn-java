// 1. **Find First Non-Repeating Element**

// **Concepts:** HashMap, counting, two-pass logic
// Given a list of integers, return the first element that does not repeat.
// Example:
// Input: `[2, 3, 4, 2, 3, 5]`
// Output: `4`
// if arr no exist in the freq add 1, else set count as 1, if freq(arr) == 1 return that arr
import java.util.*;
public class FirstNonRepeatElement {
    public static int firstNoneReapeate(int[] arr) {
        HashMap<Integer> countfreq = new HashMap<>();
        for(int num: arr){
            if(countfreq.contains(num)) {
                countfreq.put(num, countfreq.getOrDefault(num, 0) +1);
            }
            else{
                countfreq = 1;
            }
        }
        for(int num: arr){
            if(countfreq.get(num) == 1) {
                return num;
            }
        }
    }
    
}
