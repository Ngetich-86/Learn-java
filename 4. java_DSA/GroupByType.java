import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Store{
    int id;
    String type;

    Store(int id, String type) {
        this.id = id;
        this.type = type;
    }
}

public class GroupByType {
    public static List<String> groupByType(List<Store> stores) {
        HashMap <String, List<Integer>> storeHashMap = new HashMap<>();

        for(Store store: stores) {
            String storeType = store.type;
            storeHashMap.putIfAbsent(storeType, new ArrayList());
            storeHashMap.get(storeType).add(store);
        }
        return storeHashMap;
    }
    public static void main(String[] args) {
        List<Store> storeItems = Arrays.asList(
            new Store(1, "clothing"),
            new Store(5, "food")
        );
        System.out.println(Store);
    }
    
}
