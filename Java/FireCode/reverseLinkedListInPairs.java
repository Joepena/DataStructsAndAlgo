/*
Given a singly-linked list, reverse the list in pairs.
Example:
Given 1->2->3->4,
reverseInPairs(1) ==> 2->1->4->3
*/
public ListNode reverseInPairs(ListNode head) {
    if(head == null) return null;

    ListNode current = head;
    ListNode prev = null;
    head = (head.next != null)?head.next:head;
    while(current != null && current.next!= null){

        ListNode temp = current.next.next;
        current.next.next = current;
        if(prev != null){
            prev.next = current.next;
        }
        current.next = temp;
        prev = current;
        current = current.next;
    }
    return head;
}
/*
  After-Thought: swap data not reference values
*/
