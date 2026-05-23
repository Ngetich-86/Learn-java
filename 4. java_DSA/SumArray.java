// input: [1,2,3,5,6]
//output: 17

public class SumArray{
    public static int sumArray(int[] arr){
        // start at 0 index
        int sum = arr[0];
        //loop thru adding...
        for(int i =0;i < arr.length(), i++) {
            // sum = sum + arr[i]
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,5,6};
        int result = sumArray(array);
        System.out.println(result);
    }
}

// ==============================practise1
// input: [1,2,3,5,6]
//output: 17
 public class innerSum{
    public static int arrSum(int[] arr) {
        int sum = arr[0];
        for(int i = 0; i < arr.length; i++) {
            // sum = sum + arr[i];
            sum += arr[i];
        }
        return sum;
    }
 }
 // practise day3
 // input: [1,2,3,5,6]
//output: 17

public class arrSum{
    public static int arrays(int[] arr) {
        int sum = arr[0];
        for(int i=0; i < arr.length;i++) {
            sum += arr[i];
        }
        return sum;
    }
}