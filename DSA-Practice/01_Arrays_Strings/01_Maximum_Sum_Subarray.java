// //  Find the maximum sum subarray.
// class Maximum_Sum_Subarray {
//     public static void main(String[] args) {
//         int[] arr = {1, -2, 3, 4, -5, 8};
//         int maxSum = Integer.MIN_VALUE;
//         int currentSum = 0;

//         for (int i = 0; i < arr.length; i++) {
//             currentSum += arr[i];
//             if (currentSum > maxSum) {
//                 maxSum = currentSum;
//             }
//             if (currentSum < 0) {
//                 currentSum = 0;
//             }
//         }

//         System.out.println("Maximum sum subarray: " + maxSum);
//     }
// }

// Time Complexity: O(n)
// Space Complexity: O(1)


class Find_Max {
    public static int maxSum(int[] arr) {
        int max_value = Integer.MIN_VALUE;
        int current_sum = 0;

        for (int i = 0; i < arr.length; i++) {
            current_sum += arr[i];

            if (current_sum > max_value) {
                max_value = current_sum;
            }

            if (current_sum < 0) {
                current_sum = 0;
            }
        }

        return max_value;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 7};
        int result = maxSum(array);
        System.out.println(result);
    }
}