// List 1:1 → 3 → 5
// List 2: 2 → 4 → 6
// output: 1 → 2 → 3 → 4 → 5 → 6
// =====================================================Algorithm==========================
// Create a dummy node.
// Let tail point to the dummy node.
// While both lists are not empty:
// Compare the current nodes of the two lists.
// Attach the smaller node to tail.next.
// Move the pointer of the list you took the node from.
// Move tail forward.
// When one list becomes empty:
// Attach the remaining nodes of the other list to tail.next.
// Return dummy.next (not dummy, because dummy is just a helper).
// ==================================================== PSEUDOCODE=============================================
// Create dummy node
// tail = dummy
// WHILE list1 != null AND list2 != null
//     IF list1.value <= list2.value
//         tail.next = list1
//         list1 = list1.next
//     ELSE
//         tail.next = list2
//         list2 = list2.next
//     tail = tail.next
// END WHILE
// IF list1 is not empty
//     tail.next = list1
// ELSE
//     tail.next = list2
// RETURN dummy.next
// ==========================================code ================================
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeSortedLinkedList {
    public static ListNode mergeLinkedList(ListNode list1, ListNode list2) {
        // Dummy node
        ListNode dummy = new ListNode(-1);

        // Tail pointer
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create first list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Create second list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        ListNode merged = mergeLinkedList(list1, list2);

        System.out.println("Merged List:");
        printList(merged);
    }
}