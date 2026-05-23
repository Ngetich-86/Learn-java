


// Map<String, Integer> counts = new HashMap<>();

// for (String word : words) {
//     if (counts.containsKey(word)) {
//         counts.put(word, 1);
//     } else {
//         counts.put(word, counts.get(word) + 1);
//     }
// }
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IncorrectCountLogic {
    public static List incorrectCount(int[] arr) {
        HashMap<String,Integer> counts = new HashMap<>();
        // loop
        for(int word: arr){
            if(counts.containsKey(word)){
                counts.put(word, counts.getOrDefault(counts, 0) + 1);
            }
        }
        return ArrayList(counts);

    }
}