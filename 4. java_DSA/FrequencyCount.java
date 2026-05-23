// input: ['apple', 'banana', 'apple', 'oranges']
// output: apple: 2, banana: 1, oranges:1
// hashmaps, list, update - put
// loop thru the array then update the freq of count to 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyCount {
    public static List FreqCount(int[] arr) {
        HashMap<String,Integer> count = new HashMap<>();

        for(int i : arr){
            count.put(i, count.getOrDefault(count,0) +1);
        }
        return new ArrayList(count);
    }
    public static void main(String[] args) {
        int[] array = {'apple', 'banana', 'apple', 'oranges'};
        int[] resultList = FreqCount(array);
        System.out.println(resultList);
    }
    
}
