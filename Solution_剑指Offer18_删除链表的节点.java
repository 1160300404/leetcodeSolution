/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。
 */
public class Solution_剑指Offer18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node=new ListNode(-1);
        node.next=head;
        ListNode pre=node;
        while(head!=null){
            if(head.val==val){
                pre.next=head.next;
                head.next=null;
                break;
            }
            pre=head;
            head=head.next;
        }
        return node.next;
    }
}
