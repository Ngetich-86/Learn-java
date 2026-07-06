//Given the head of a singly linked list, return the middle node.
// If there are two middle nodes (when the list has an even number of nodes), return the second middle node.
// input: 1 → 2 → 3 → 4 → 5
// output: 3
//=======================================Algorithm==========================================
// 1. Create two pointers:
//       slow = head
//       fast = head

// 2. While fast is not null
//       AND fast.next is not null
//       Move slow one step.
//       Move fast two steps.
// 3. When the loop ends,
//       slow is pointing to the middle node.
// 4. Return slow.
//==================================code======================================================
class Middle_LinkList {
    public static ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.head;
            fast = fast.next.next;
        }
        return slow;
    }
}