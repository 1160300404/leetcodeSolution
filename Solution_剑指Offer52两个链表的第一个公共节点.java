import java.util.Stack;

public class Solution_剑指Offer52两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack=new Stack<>();
        Stack<ListNode> stack1=new Stack<>();
        ListNode node=headA;
        while (node!=null){
            stack.push(node);
            node=node.next;
        }
        node=headB;
        while (node!=null){
            stack1.push(node);
            node=node.next;
        }
        while (!stack.isEmpty()&&stack1.isEmpty()){
            if (stack.peek()==stack1.peek()){
                node=stack.pop();
                stack1.pop();
            }else{
                return node;
            }
        }
        return null;
    }
}
