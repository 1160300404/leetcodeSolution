package Solution;


// 删除有序链表中重复元素 2
public class Solution82 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head==null||head.next==null)
            return head;
        ListNode node=head.next;
        while(node!=null&&head.val==node.val){
            while(node!=null&&node.val==head.val){
                node=node.next;
            }
            if(node==null)
                return null;
            head=node;
            node=head.next;
        }
        node=head.next;
        ListNode node2=head;;
        while(node!=null&&node.next!=null){
            if(node.val!=node.next.val){
                node2=node;
            }else{
                while(node.next!=null&&node.val==node.next.val){
                    node=node.next;
                }
                node2.next=node.next;
            }
            node=node.next;
        }
        return head;
    }
}
