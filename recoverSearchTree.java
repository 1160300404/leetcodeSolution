package Solution;


public class recoverSearchTree {
    TreeNode pre,mistake1,mistake2;
    public void recoverTree(TreeNode root) {
        inTraversal(root);
        mistake1.val=mistake2.val^mistake1.val^(mistake2.val=mistake1.val);
    }
    public void inTraversal(TreeNode root){
        if(root==null) return ;
        inTraversal(root.left);
        if(pre!=null&&pre.val>root.val){
            if(mistake1==null){
                mistake1=pre;
                mistake2=root;
            }else mistake2=root;
        }
        pre=root;
        inTraversal(root.right);
    }
}
