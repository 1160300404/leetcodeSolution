package Solution;


import java.util.*;

public class Solution145 {
    public ArrayList<Integer> postorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || prev==root.right) {
                res.add(root.val);
                prev = root;
                root = null;
                //stack.pop();
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
