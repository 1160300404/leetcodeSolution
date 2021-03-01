public class Solution剑指Offer24_反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode tmphead=new ListNode(0);
        ListNode pre=null;
        tmphead.next=head;
        ListNode curnode=head;
        ListNode nextnode=head.next;
        while(nextnode!=null){
            curnode.next=pre;
            pre=curnode;
            curnode=nextnode;
            nextnode=nextnode.next;
        }
        curnode.next=pre;
        pre=curnode;
        return pre;
    }
}
