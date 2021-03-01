/*
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Solution剑指Offer26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;
        if(SubStructure(A,B)){
            return true;
        }else{
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
    }
    public boolean SubStructure(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null) return false;
        if(A.val==B.val){
            return SubStructure(A.left,B.left)&&SubStructure(A.right,B.right);
        }else {
            return false;
        }
    }
}
