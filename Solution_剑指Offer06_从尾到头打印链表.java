package Solution;
/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution_剑指Offer06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if(head==null) return null;
        int length=0;
        ListNode node=head;
        while (node!=null){
            length++;
            node=node.next;
        }
        int[] ans=new int[length];
        int count=0;
        while (head!=null){
            count++;
            ans[length-count]= head.val;
            head=head.next;
        }
        return ans;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}