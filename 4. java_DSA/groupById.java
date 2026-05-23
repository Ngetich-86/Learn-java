import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Items{
    int id;
    String type;
    Items(int id, String type){
        this.id= id;
        this.type= type;
    }
}

public class groupById {
    public static List<Integer> groupById(List<Items> items) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        // 
        for(Items item: items) {
            // 
            result.putIfAbsent(item.type, new ArrayList<>());
            result.get(item.type).add(item.id);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Items> items = Arrays.asList(
            new Items(1, "A"),
            new Items(3, "b")
        );
        System.out.println(items);
    }
    
}
