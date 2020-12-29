package Solution;

import java.util.ArrayList;

public class 二叉树根节点到叶子节点和为指定值的路径 {
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        sum = sum - root.val;
        //判断是否是叶子
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                ans.add(tmp);
            }
        } else {
            ArrayList<ArrayList<Integer>> left = pathSum(root.left, sum);
            for (int i = 0; i < left.size(); i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                tmp.addAll(left.get(i));
                ans.add(tmp);
            }
            ArrayList<ArrayList<Integer>> right = pathSum(root.right, sum);
            for (int i = 0; i < right.size(); i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                tmp.addAll(right.get(i));
                ans.add(tmp);
            }
        }
        return ans;
    }
}
