
import java.util.HashSet;

class Detect_Cycle {
    public static Boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();

        while(head != null){
            if(seen.contains(head)){
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }
}


public boolean hasCycle(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast) {
            return true;
        }
    }

    return false;
}