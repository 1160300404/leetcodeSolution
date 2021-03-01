import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution_剑指Offer32_III从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        boolean fromleft=false;
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<Integer> tmp=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            if(queue.peek()==null){
                queue.poll();
                if(!queue.isEmpty())
                    queue.offer(null);
                list.add(tmp);
                tmp=new ArrayList<>();
                fromleft=!fromleft;
            }else {
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(fromleft){
                    tmp.add(node.val);
                }else {
                    tmp.add(0,node.val);
                }
            }
        }
        return list;
    }
}
