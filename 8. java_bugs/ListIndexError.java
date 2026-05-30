//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

// for (int i = 0; i <= numbers.size(); i++) {
//     System.out.println(numbers.get(i));
// }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

import java.util.ArrayList;

public class ListIndexError {
    public static List listIndexError(int[] arr) {
        List<Interger> numbers = new ArrayList<>();
        for(int i= 0; arr.length;i++) {
            numbers += arr[i];
            // update numbers
            numbers.get(i);
        }
        return ArrayList(numbers);
    }
}