// input: 1,2,3,5,6,7,8,9
// output : 4
// loop thru the strings checking if prev + 1 = next 
// Rule if arr[i+1] != arr[i] + 1

public class find_missing_no {
    public static Integer missingNo(Integer[] arr) {
        // if 1 is not equal to no(1) + 1 
        for( int i = 0; i < arr.length; i++) {
            if(arr[i + 1] != arr[i]+1){
                // then no is currently at 1
                return arr[i] + 1;
            }
        }
        return -1;
    }
}
