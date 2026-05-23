// 1. **Remove Duplicates from a List**

// **Concepts:** HashSet / HashMap, loops, uniqueness

// Given a list of integers, return a new list with all duplicate values removed.

// Example:
// Input: `[1, 2, 2, 3, 1, 4]`
// Output: `[1, 2, 3, 4]`
// if no. is not seen add it to seen then add it to result

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesList {
    public static List<Integer> removeDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        int[] result = new ArrayList();
        for(int num: arr) {
            if(!num.contains(seen)) {
                seen.add(num);
                result.add(num);
            }
            return result;
        }

    }
    
}


// test practice
// Input: `[1, 2, 2, 3, 1, 4]`
// Output: `[1, 2, 3, 4]`
// if no. is not seen add it to seen then add it to result

public class InnerRemoveDuplicatesList {
    public static int[] getDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        int[] results = new ArrayList<>();
         for(int num: arr){
            if(!seen.contains(num)) {
                seen.add(num);
                results.add(num); 
            }
         }
         return results;
    }  
}