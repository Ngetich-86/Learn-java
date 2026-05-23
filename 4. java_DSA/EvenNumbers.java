import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {
    public static List<Integer> getEvenNo(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        for(int num: arr) {
            if(num % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }
    
}
