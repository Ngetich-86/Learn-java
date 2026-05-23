// write a function that returns max element in an array
// input [1,2,3,5,6,9]
// output:9
//current element, max is at first arr, if current > max update
//loop thru untill max is fully updated after

public class MaxElement{
    public static int isMax(int[] arr){
        int max = arr[0];
        for(int i=0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            } 
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,5,9};
        int result = isMax(arr);
        System.out.println(result);
    }
}