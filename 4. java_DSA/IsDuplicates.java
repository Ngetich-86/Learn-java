// 1. **Check for Duplicates***(note: Loom has a 5 min limit, so we recommend using an alternative like Vimeo, which has a 30 min limit)*

// **Concepts:** HashSet, loops, early exit logic
// Write a function that returns true if a list contains any duplicate values, otherwise false.
// Example:
// Input: `[1, 2, 3, 4]` → false
// Input: `[1, 2, 3, 1]` → true
// if no is seen return true else add no to seen

import java.util.HashSet;

public class IsDuplicates {
    public static Boolean containsDuplicate(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        // loop thru
        for(int i: arr){
            if(seen.contains(i)) {
                return true;
            }
            else{
                seen.add(i);
            }
            return false;
        }

    }
    
}
