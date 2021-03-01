/*
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next
指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。


 */
public class Solution_剑指Offer35复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node node=head;
        while(node!=null){
            Node new_node=new Node(node.val);
            new_node.next=node.next;
            node.next=new_node;
            node=new_node.next;
        }
        node=head;
        Node node1=head.next;
        Node head2=head.next;
        while(node!=null){
            node1.random=node.random==null?null:node.random.next;
            node=node1.next;
            node1=node==null?null:node.next;
        }
        node=head;
        node1=head.next;
        while(node!=null){
            node.next=node1.next;
            node1.next=node.next==null?null:node.next.next;
            node=node.next;
            node1=node1.next;
        }
        return head2;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}