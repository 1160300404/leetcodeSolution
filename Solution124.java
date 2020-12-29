package Solution;
public class Solution124 {
    public int maxPathSum (TreeNode root) {
        // write code here
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        bigest_sum(root,max);
        return max[0];
    }
    public int  bigest_sum(TreeNode node,int[] max) {
        if(node==null)
            return 0;
        int left=bigest_sum(node.left,max);
        int right=bigest_sum(node.right,max);
        if(right<0&&left<0){
            max[0]=Math.max(max[0],node.val);
            return node.val;
        }
        else if(right<0){
            max[0]=Math.max(max[0],left+node.val);
            return left+node.val;
        }else if(left<0){
            max[0]=Math.max(max[0],right+node.val);
            return right+node.val;
        }else {
            max[0]=Math.max(max[0],right+node.val+left);
            int tmp=left>right?left:right;
            return tmp+node.val;
        }
    }
}
