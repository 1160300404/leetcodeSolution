public class Solution_剑指Offer07_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rebuild(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode rebuild(int[] preorder, int a,int b,int[] inorder,int c,int d){
        if(a>=b) return null;
        if(a==b-1) return  new TreeNode(preorder[a]);
        TreeNode node=new TreeNode(preorder[a]);
        for(int i=c;i<d;i++){
            if(inorder[i]==preorder[a]){
                node.left=rebuild(preorder,a+1,i+a+1-c,inorder,c,i);
                node.right=rebuild(preorder,i-c+a+1,b,inorder,i+1,d);
                break;
            }
        }
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
