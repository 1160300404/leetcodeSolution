package Solution;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addone=0;
        ListNode result=new ListNode();
        ListNode head=result;
        while(l1!=null||l2!=null){
            ListNode tmp=new ListNode();
            result.next=tmp;
            result=result.next;
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int val=(num1+num2+addone)%10;
            addone=(num1+num2+addone)/10;
            result.val=val;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(addone==1){
            ListNode last=new ListNode(addone);
            result.next=last;
        }
        return head.next;
    }
}
