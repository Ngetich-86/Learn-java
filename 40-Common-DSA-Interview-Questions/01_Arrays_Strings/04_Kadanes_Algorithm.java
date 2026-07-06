// Given an array of numbers, find the contiguous subarray with the largest sum.
// input: [-2,1,-3,4,-1,2,1,-5,4]
// output: [4,-1,2,1]
// sum: sum = 6
// Should I continue my current subarray OR should I start a new one here

// ########################################ALGORYTHM#########################################
// 1. Create currentSum
// 2. Create maxSum
// 3. Set both equal to first element

// 4. Loop from second element to the end:

//       current number = array[i]

//       Decide:
//           continue old subarray
//           OR
//           start new subarray

//       currentSum = bigger of:
//           current number
//           currentSum + current number

//       Update maxSum if currentSum is bigger

// 5. Return maxSum

class KadaneAlgorithmn {
    public static int kadanesAlgo(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.lenght; i++){
            currentSum = math.max(nums[i], currentSum + nums[i]);
            maxSum = math.max( maxSum, currentSum);
        }
        return max;
    }
    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(nums);

        System.out.println(result);
    }
}