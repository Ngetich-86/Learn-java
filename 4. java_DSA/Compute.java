// **Concepts:** loops, aggregation, variables (sum, min, max)

// Given a list of integers, return the sum, average, minimum, and maximum values.
// Example:
// Input: `[2, 4, 6, 8]`
// Output: `sum = 20, avg = 5, min = 2, max = 8`

import java.util.List;

public class Compute {
    public static int[] getStats(int[] arr) {
        int sum = 0;
        int min = 0;
        int max = 0;
        for(int num: arr){
            sum += num;
            if(num < min) {
                min =  num;
            }
            if(num > max) {
                max = num;
            }
        }
        double avg = (double) sum / arr.length;
    }
}