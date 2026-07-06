// input: 1 -> 2 -> 3 -> 4 -> 5 -> null
//return: 5 -> 4 -> 3 -> 2 -> 1 -> null

public ListNode reverseList(ListNode head){
    ListNode curr = head;
    ListNode prev = null;

    while(curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;

}