public class Solution剑指Offer25_合并两个排序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmphead=new ListNode(0);
        ListNode node=tmphead;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                node.next=l2;
                l2=l2.next;
            }else {
                node.next=l1;
                l1=l1.next;
            }
            node=node.next;
        }
        if(l1!=null) node.next=l1;
        else node.next=l2;
        return tmphead.next;
    }
}
