// input: [1,2,3,5,5,2,6,7]
// output: [2,5]
// use hashset - a collection that stores unique values only
// we use seen and duplicates to loop this array and check their existance
// if index no is already seeen mark as duplicate else mark as seen

import java.util.HashMap;

class FindDuplicates {
    public static List<Integer> findDuplicates(int[] num) {
        HashMap<integer> seen = new HashMap<>();
        HashMap<integer> duplicate = new HashMap<>();

        if(num.containskey(seen)) {
            duplicate.add(num);
        }
        else {
            seen.add(nums)
        }
        return ArrayList(duplicate);
    }
    public static void main(String[] args) {
        int[] array = {1,2,2,3,5,3,6,7};
        int[] results = findDuplicates(array);
        System.out.println(results);
    } 
}