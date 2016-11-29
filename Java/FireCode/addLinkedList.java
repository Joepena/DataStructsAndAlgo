/*
Given two integers represented as linked-lists, find their sum and return it in the form of linked list.
Input 1: 1->2->3
Input 2: 1->2->3  
Output : 2->4->6 

Input 1: 9->9
Input 2: 9->8 
Output : 8->8->1
*/
public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
    if(input1 == null || input2 == null) return (input1!=null)?input1:input2;
    ListNode tracer1 = input1;
    ListNode tracer2 = input2;
    ListNode ans = new ListNode(0);
    ListNode ansTracer = ans;
    boolean makeNew = false;
    
    while(tracer1 != null && tracer2 != null){
        if(makeNew){
            ansTracer.next = new ListNode(0);
            ansTracer = ansTracer.next;
            makeNew = false;
        }
        //create a carry
        if((ansTracer.data +tracer1.data+tracer2.data) > 9){
            ansTracer.data = (ansTracer.data+tracer1.data+tracer2.data)%10;
            ansTracer.next = new ListNode((tracer1.data+tracer2.data)/10);
            ansTracer = ansTracer.next;
        }
        else{
            ansTracer.data += (tracer1.data+tracer2.data);
            makeNew = true;
        }
        tracer1 = tracer1.next;
        tracer2 = tracer2.next;
    }

    while(tracer1 != null){
        ansTracer.next = new ListNode(tracer1.data);
        tracer1 = tracer1.next;
        ansTracer = ansTracer.next;

    }
    while(tracer2 != null){
        ansTracer.next = new ListNode(tracer2.data);
        tracer2 = tracer2.next;
        ansTracer = ansTracer.next;
    }
    return ans;
}