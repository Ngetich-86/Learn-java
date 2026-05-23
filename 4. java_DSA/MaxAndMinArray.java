// input: [1,2,3,5,6,7,9]
// output: max: 9, min: 1


public class MaxAndMinArray {
    public static int maxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i>arr.length;i++) {
            if(i > max){
                max = arr[i];
                return max;
            }
            // return max;
            if(i < min){
                min = arr[i];
                return min;
            }
        }
        public static void main(String[] args) {
            int[] arr = {1,2,3,5,6,7};
            int result = maxAndMin(arr);
            System.out.println(result);
        }

    }
    
}
