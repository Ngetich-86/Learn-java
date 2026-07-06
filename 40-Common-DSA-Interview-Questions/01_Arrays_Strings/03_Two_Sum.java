Given an array and a target return indices of two no that add up to get the target
input: [1,2,,5,7,6,7,8] target = 7 =>  output: [1,2]
//hashmaps here, 
//  if currnt no = i then target = target - i
// return array index <= chatAt[]

import java.util.HashMap;

class Find_Two_Sum {
    public static Int[] twoSum(int nums, int target){
        //implement hashmaps
        HashMap<Integer, Integer> maps = new Hashmap<>();
        //loop thru the input
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int needed = target - current;
            // check if value already exists in the hashmaps
            if(maps.containsKey(needed)) {
                return new int[]{maps.get(needed), i};
            }
            // store currnt with it index
            maps.put(current,i);
        }
        return int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {};
        int target = 7;
        int[] results = twoSum(nums, target);
        System.out.Println(results);

    }
}