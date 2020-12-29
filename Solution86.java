package Solution;


public class Solution86 {
    public ListNode partition (ListNode head, int x) {
        // write code here
        if(head==null)
            return null;
        ListNode small=new ListNode(0);
        ListNode big=new ListNode(0);
        ListNode small_last=small;
        ListNode big_last=big;
        while(head!=null){
            if(head.val<x){
                small_last.next=head;
                small_last=head;
            }else{
                big_last.next=head;
                big_last=head;
            }
            head=head.next;
        }
        big_last.next=null;
        small_last.next=big.next;
        return small.next;
    }
}
