package Solution;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode slow=head.next;
        ListNode fast=head.next;
        while(fast.next!=null&&fast.next.next!=null){ //make sure slow is n/2
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
        ListNode tmp=slow.next; //split list
        slow.next=null;
        ListNode pre=null;
        while(tmp!=null){ //reverse list
            ListNode next=tmp.next;
            tmp.next=pre;
            pre=tmp;
            tmp=next;
        }
        while(pre!=null){
            tmp=fast.next;
            fast.next=pre;
            pre=pre.next;
            fast.next.next=tmp;
            fast=tmp;
        }
    }
}
