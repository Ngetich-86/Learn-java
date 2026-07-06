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

class MergeSortedLinkedList {
    public static ListNode MergeLinkedList(ListNode list1, ListNode list2) {
        // create a dummy
        ListNode dummy = new ListNode(-1);
        //Tail always points to the last node in the merged list
        ListNode tail = dummy;
        // Compare nodes while both lists still have elements
        while(list1 != null && list2 != null){
            if(list1.value <= list2.value){
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            // Move tail forward
            tail = tail.next;
        }
        // attach whatever remains
        if(list1 != null) {
            tail.next = list1;
        }
        else {
            tail.next = list2;
        }
        // return merged list
        return dummy.next;
    }
}