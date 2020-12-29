package Solution;

import java.util.Stack;

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        int ans=0;
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return root.val;
        }
        ans=dfs(root,root.val);
        return ans;
    }
    public int dfs(TreeNode node,int sum){
        if(node==null){
            return 0;
        }
        int tmp=sum*10+node.val;
        if(node.left==null&&node.right==null){
            return tmp;
        }

        return dfs(node.left,tmp)+dfs(node.right,tmp);
    }
}
