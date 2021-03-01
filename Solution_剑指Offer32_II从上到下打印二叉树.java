import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */
public class Solution_剑指Offer32_II从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> tmp=new ArrayList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            if(queue.peek()==null){
                queue.poll();
                queue.offer(null);
                list.add(tmp);
                tmp=new ArrayList<>();
            }else {
                TreeNode node=queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }

        }
        return list;
    }
}
