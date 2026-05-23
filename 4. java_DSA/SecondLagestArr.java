// find second largest no in an array, 
// input: [1,2,3,5]
// output: 3
// pseudocode: max no, secondmax,
// if index no is > max, 
// if we loop thru the array and compare if num is > than max update the secondmax to max 
// else num  < secondnum and num != max then secondmax = num
public class SecondLagestArr{
    public static int secondMaxArray(int[] num) {
        int max = num[0];
        // int secondMax= Integer.MIN_Value;
        int secondMax = Integer.MIN_VALUE;

        for(int i=0; i < num.length; i++) {
            if(num[i] > max){
                secondMax = max;
                max[i] = num[1];
            }
            else(num[i] < secondmax && num[1] != max){
                secondMax = num;
            }
        }
        return secondMax;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,5,6,7};
        int result = secondMaxArray(array);
        System.out.println(result);
    }
}

// find second largest no in an array, 
// input: [1,2,3,5]
// output: 3
// pseudocode: max no, secondmax,
// if index no is > max, 
// if we loop thru the array and compare if num is > than max update the secondmax to max 
// else num  < secondnum and num != max then secondmax = num
 public class test123{
    public static int arrayList(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        // loop thru
        for(int num: arr) {
            if(num > max) {
                secondMax = max;
                max = num;
            }
            else(num < secondMax && num != max){
                secondMax = num;
            }
        }
        return secondMax;

    }
 }