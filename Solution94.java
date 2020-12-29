package Solution;


import java.util.*;

public class Solution94 {
    public ArrayList<Integer> inorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            res.add(node.val);
            root=node.right;
        }
        return res;
    }
}
