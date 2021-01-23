//package leetcode;
//
//
//public class Solution110 {
//    boolean ans=true;
//    public boolean isBalanced (TreeNode root) {
//        // write code here
//        height(root);
//        return ans;
//    }
//    public int height(TreeNode node){
//        if(node==null)
//            return 0;
//        int left=height(node.left);
//        int right=height(node.right);
//        if(Math.abs(left-right)>1)
//            ans=false;
//        return Math.max(left,right)+1;
//    }
//}
