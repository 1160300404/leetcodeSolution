package Solution;


public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        // write code here
        ListNode ans=new ListNode(0);
        ListNode tmp=head.next;
        ans.next=head;
        head.next=null;
        head=tmp;
        while(head!=null){
            tmp=head.next;
            ListNode pre=ans;
            head.next=null;
            while(pre.next!=null&&head.val>pre.next.val){
                pre=pre.next;
            }
            head.next=pre.next;
            pre.next=head;
            head=tmp;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        //String s="asd";
        String s="";
        s=s+'a';
        System.out.println(s);
    }
}
