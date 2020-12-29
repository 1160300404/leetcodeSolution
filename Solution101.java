package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {
    public boolean isSymmetric1 (TreeNode root) {
        // write code here
        if(root==null)
            return true;
        Queue<TreeNode> left=new LinkedList<>();
        Queue<TreeNode> right=new LinkedList<>();
        left.offer(root.left);
        right.offer(root.right);
        while(!left.isEmpty()){
            TreeNode tmp_left=left.poll();
            TreeNode tmp_right=right.poll();
            if(tmp_left!=null&&tmp_right!=null){
                if(tmp_left.val!=tmp_right.val)
                    return false;
            }else if(tmp_left==null&&tmp_right==null){
                continue;
            }else{
                return false;
            }
            left.offer(tmp_left.left);
            left.offer(tmp_left.right);
            right.offer(tmp_right.right);
            right.offer(tmp_right.left);
        }
        return true;
    }
    public boolean isSymmetric2 (TreeNode root) {
        if(root==null)
            return true;
        return isequal(root.left,root.right);
    }
    public boolean isequal(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }else if(left==null||right==null||left.val!=right.val){
            return false;
        }
        else
            return isequal(left.left,right.right)&&isequal(left.right,right.left);
    }
}
