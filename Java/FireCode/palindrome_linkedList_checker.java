/*
Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome. A palindrome is a sequence that reads the same backward as forward.
Examples:

1->2->3->2->1 ==> true

1->2->2->3 ==> false

1 ==> true

null ==> true
*/
//constant memory is used in this
public Boolean isListPalindrome(ListNode head) {
    if(head == null) return true;
    ListNode walker =head;
    ListNode runner = head;
    //reverse the second half
    while(runner.next != null && runner.next.next != null){
        runner = runner.next.next;
        walker = walker.next;
    }
    while(runner.next != null){
        runner = runner.next;

    }
    //now we have the mid point reverse [mid to runner]
    ListNode prev = null;
    //reversed the bottom half
    while(walker!= null){
        ListNode temp = walker.next;
        walker.next = prev;
        prev = walker;
        walker = temp;
    }
    //iterate through both and check for a mismatch
    while(head != null && runner!=null){
        if(head.data != runner.data) return false;
        head = head.next;
        runner = runner.next;
    }
    return true;

}
