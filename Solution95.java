package Solution;


import java.util.ArrayList;

// 不同的二叉搜索树II
public class Solution95 {
    public ArrayList<TreeNode> generateTrees (int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        // write code here
        return getTree(1,n);
    }
    public  ArrayList<TreeNode> getTree(int left,int right){
        ArrayList<TreeNode> ans=new ArrayList<>();
        if(right-left==-1){
            ans.add(null);
            return ans;
        }
        if(right-left==0){
            TreeNode first=new TreeNode(left);
            ans.add(first);
            return ans;
        }
        for(int i=left;i<=right;i++){
            ArrayList<TreeNode> left_tree=getTree(left,i-1);
            ArrayList<TreeNode> right_tree=getTree(i+1,right);
            for(int j=0;j<left_tree.size();j++){
                for(int k=0;k<right_tree.size();k++){
                    TreeNode node=new TreeNode(i);
                    node.left=left_tree.get(j);
                    node.right=right_tree.get(k);
                    ans.add(node);
                }
            }
        }
        return ans;
    }

}
