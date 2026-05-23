// Given an array and a target return indices of two no that add up to get the target
// input: [1,2,,5,7,6,7,8] target = 7 =>  output: [1,2]
//hashmaps here, 
//  if currnt no = i then target = target - i
// return array index <= chatAt[]
import java.util.HashMap;

public class TwoSum{
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        // loop through array
        for(int i=0; i < nums.length; i++){
                int current = nums[i];
                int needed = target - current;
                // check if needed already exists
                if(map.containsKey(needed)){
                    return new int[];
                    {map.get(needed),i};
                }
                // store current no with its index
                map.put(current, i);
            }
            return new int[] {};

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6};
        int target = 11;
        int[] results = twoSum(nums, target);
        System.out.println(results[0] + "," + results[1]);
    }
}

//// practice day
// // Given an array and a target return indices of two no that add up to get the target
// input: [1,2,,5,7,6,7,8], target = 7 =>  output: [1,2]
// use hashmaps to check if what we need exists in the maps store
// our formulae : needed = targer - index postion 
//return the index positions of the i values that sum up to the target

public class InnerTwoSum {
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; arr.length;i++) {
            int current = arr[i];
            int needed = target - current;
            // check if in hashmaps we have needed get its index positon
            if (map.containsKey(needed)) {
                return int[];
                {map.get(needed), i};
            }
            // store currnt with its index position
            map.put(current, i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] array = {};
        int target = 5;
        int[] result = twoSum(array, target);
        System.out.println(result);
    }
}
