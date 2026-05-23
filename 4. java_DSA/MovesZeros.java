// write a function to move zeros to the end of an array while maintaining order  of the non zero elements
// input: [1,0,2,3,0,5,6]
// output: [1,2,3,5,6,0,0]
// use pointers
// swap,swap non zeros forward
// if array index is 0 ignore, if non zero swap forward
// 

public class MovesZeros{
    public static int moveZeros(int[] arr){
        int pointer = 0;
        for(int i=0;i<arr.length;i++){
            //swap if zero move forward
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
    }
    public static void main(String args){
        int[] array = {1,2,0,2,0,9,8,7};
        int result = moveZeros(array);
        System.out.println(result);
    }
}