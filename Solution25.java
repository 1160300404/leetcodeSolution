package Solution;

//25. K 个一组翻转链表
/*
给你一个链表，每  k  个节点一组进行翻转，请你返回翻转后的链表。

k  是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是  k  的整数倍，那么请将最后剩余的节点保持原有顺序。

 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;
        int half=k/2;
        ListNode first=head;
        ListNode second=first;
        ListNode next_f=first.next;
        ListNode pre_f=null;
        while(first!=null){
            next_f=first.next;
            for(int i=0;i<k-1;i++){
                second=second.next;
                if(second==null) break;
            }
            if(second==null) break;
            first.next=second.next;
            second.next=null;
            ListNode node=first;
            for(int i=0;i<k-1;i++){
                ListNode tmp=next_f.next;
                next_f.next=node;
                node=next_f;
                next_f=tmp;
            }
            if(pre_f!=null) pre_f.next=second;
            else head=second;
            pre_f=first;first=first.next;second=first;
        }
        return head;
    }
}
