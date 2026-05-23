// 1. **Group Items by Category**
// **Concepts:** HashMap, grouping, Map<String, List>, loops
// Given a list of items with a category field, group them into a map where the key is the category and the value is a list of items in that category.
// Example:
// Input: `[{name: "Shirt", category: "Clothing"}, {name: "Phone", category: "Electronics"}, {name: "Pants", category: "Clothing"}]`
// Output: `{"Clothing": ["Shirt", "Pants"], "Electronics": ["Phone"]}`
//loop thru if Items.category  = clothing  upadte hashmap count to if item already appears in count add + 1, else update count to 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Item{
    String name;
    String category;

    Item(String name,String category) {
        this.name = name;
        this.category= category;
    }
}


public class GroupItemsByCat {
    public static List<Item> groupByCategory(List<Item> items) {
    HashMap<String, List<Item>> map = new HashMap<>();
    for(Item item: items) {
            String category = item.category;
            // if category is absent initialize a list
            map.putIfAbsent(category, new ArrayList<>());
            // add items to the category list
            map.get(category).add(item);
    }
    return map;
    }
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item("apple", "fruit"),
            new Item("jumper", "clothing")
        );
        HashMap<String, List<Item>> grouped = groupByCategory(items);
        for(String category: grouped.keySet()) {
            System.out.println(category + ":");
        }
        for(Item item: grouped.get(category)) {
            System.out.println(item.name + "");
        }

    }
    
}
