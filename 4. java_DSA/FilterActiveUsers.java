// 1. **Filter Active Users**
// **Concepts:** loops, conditionals, filtering objects
// Given a list of users with an `active` flag, return a list containing only active users.
// Example:
// Input: `[{name: "Alice", active: true}, {name: "Bob", active: false}]`
// Output: `[{name: "Alice", active: true}]`
// if user.status == active, add user to results

class User {
    String name;
    String status;

    User(String name, String status){
        this.name = name;
        this.status = status;
    }
}
public class FilterActiveUsers {
    public static List<User> getActiveUsers(List<User> users) {
        // int[] result = new List();
        List<User> result = new ArrayList<>();
        for(User user: users){
            if(user.status.equals("active")) {
                result.add(user);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice","active"));
        List<User> activeUsers = getActiveUsers();
    }
}
