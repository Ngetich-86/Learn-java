// 1. **Find First Non-Repeating Element**
// **Concepts:** HashMap, counting, two-pass logic
// Given a list of integers, return the first element that does not repeat.
// Example:
// Input: `[2, 3, 4, 2, 3, 5]`
// Output: `4`
// if arr no exist in the freq add 1, else set count as 1, if freq(arr) == 1 return that arr

import java.util.HashMap;

class First_None_Repeating_Elements {
    public static int firstNoneRep(int[] arr) {
        HashMap<Integer, Integer> countfreq = new HashMap<>();
        // count frequencies
        for(int num : arr) {
            countfreq.put(num, countfreq.getOrDefault(num, 0) + 1);
        }
        // find first non-repeating
        for(int num : arr) {
            if(countfreq.get(num) == 1) {
                return num;
            }
        }
        return -1; // no non-repeating element
    }

    public static void main(String[] args){
        int[] arr = {2,3,4,2,3,5};
        System.out.println(firstNoneRep(arr));
    }
}