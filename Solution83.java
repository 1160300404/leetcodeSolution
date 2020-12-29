package Solution;

// 删除有序链表中重复元素
public class Solution83 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
