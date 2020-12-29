package Solution;

public class 二叉树中是否存在节点和为指定值的路径 {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        boolean ans=false;
        if (root == null){
            return false;
        }
        sum = sum - root.val;
        //判断是否是叶子
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans=true;
            }
        } else {
            ans=hasPathSum(root.left, sum)||hasPathSum(root.right, sum);
        }
        return ans;
    }
}
