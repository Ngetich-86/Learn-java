// List A: 1 → 2 → 3 → 8 → 9
// List B: 5 → 6 ↗
//                 8 → 9

// ======================================Algorithm======================================
// Create two pointers:
// pointerA = headA
// pointerB = headB
// While pointerA != pointerB:
// If pointerA becomes null, move it to headB; otherwise move it to pointerA.next.
// If pointerB becomes null, move it to headA; otherwise move it to pointerB.next.
// When the loop ends:
// If they intersect, both pointers are at the intersection node.
// If they don't, both are null.
// Return the pointer.
//=======================================Pseudocode=========================================
// pointerA = headA
// pointerB = headB
// WHILE pointerA != pointerB
//     IF pointerA == null
//         pointerA = headB
//     ELSE
//         pointerA = pointerA.next
//     IF pointerB == null
//         pointerB = headA
//     ELSE
//         pointerB = pointerB.next
// RETURN pointerA
//=======================================code================================================
class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class IntersectionOfLinkedList {
    public static ListNode intersectionOfLinkedList(ListNode headA, ListNode headB){
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != pointerB) {
            if(pointerA = null) {
                pointerA = pointerB;
            }
            else {
                pointerA = pointerA.next;
            }
            if(pointerB = null) {
                pointerB = pointerA;
            }
            else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
    public static void main(String[] args) {

        /*
                Shared Part
                 8 -> 9
        */

        ListNode shared = new ListNode(8);
        shared.next = new ListNode(9);

        /*
            List A

            1 -> 2 -> 3 -> 8 -> 9
        */

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = shared;

        /*
            List B
            5 -> 6 -> 8 -> 9
        */

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = shared;

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}