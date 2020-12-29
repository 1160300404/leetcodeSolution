package Solution;


public class Solution111 {
    public int minDepth (TreeNode root) {
        if(root==null){
            return 0;
        }
        return mindeep(root);
    }
    public int mindeep(TreeNode node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        return Math.min(mindeep(node.left),mindeep(node.right))+1;
    }
}
