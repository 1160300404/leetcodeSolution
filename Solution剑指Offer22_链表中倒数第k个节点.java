public class Solution剑指Offer22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node=head;
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        node=head;
        k=k%length;
        if(k==0) return head;
        while(k>1){
            node=node.next;
        }
        while(node!=null){
            node=node.next;
            head=head.next;
        }
        return head;
    }
}
