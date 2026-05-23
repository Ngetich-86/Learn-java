
// input: [1,2,3,5,5,2,6,7]
// output: [2,5]
// use hashset - a collection that stores unique values only
// we use seen and duplicates to loop this array and check their existance
// if index no is already seeen mark as duplicate else mark as seen
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for(int num: nums) {
            if(seen.contains(nums)){
                duplicates.add(nums);
        }
        else{
            seen.add(nums);
        }
        return new ArrayList(duplicates);
        }
    }
    public static void Main(String[] args){
        int[] arr = {1,2,5,5,6,1,8};
        // System.Out.Println(arr);
        int[] results = findDuplicates(arr);

    }  
}
//===========================================practise 1
// input: [1,2,3,5,5,2,6,7]
// output: [2,5]
// use hashset - a collection that stores unique values only
// we use seen and duplicates to loop this array and check their existance
// if index no is already seeen mark as duplicate else mark as seen
 public class inner_Find_Duplicates {
    public static List<Integer> innerFindDuplicates(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for(int num: nums) {
            if(seen.contains(num)){
                duplicates.add(num);
            }
            else{
                seen.add(num);
            }
        }
        return ArrayList(duplicates);
    }
    public static void main(String[] args) {
        int[] array = {1,2,2,3,5,3,6,7};
        int[] results = innerFindDuplicates(array);
        System.out.println(results);
    }  
 }