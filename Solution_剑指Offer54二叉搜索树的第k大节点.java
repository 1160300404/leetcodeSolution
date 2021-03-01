public class Solution_剑指Offer54二叉搜索树的第k大节点 {
    int index=0;
    int ans=0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return this.ans;
    }
    public void dfs(TreeNode node,int k){
        if(node==null) return;
        dfs(node.right,k);
        index++;
        if(index==k){
            this.ans=node.val;
            return;
        }else if(index>k){
            return;
        }
        dfs(node.left,k);
    }
}
