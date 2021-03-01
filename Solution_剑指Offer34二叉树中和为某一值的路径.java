import java.util.ArrayList;
import java.util.List;

/*
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Solution_剑指Offer34二叉树中和为某一值的路径 {
    public List<List<Integer>> pathSum2 (TreeNode root, int sum) {
        // write code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        sum = sum - root.val;
        //判断是否是叶子
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                ans.add(tmp);
            }
        } else {
            List<List<Integer>> left = pathSum2(root.left, sum);
            for (int i = 0; i < left.size(); i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                tmp.addAll(left.get(i));
                ans.add(tmp);
            }
            List<List<Integer>> right = pathSum2(root.right, sum);
            for (int i = 0; i < right.size(); i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(root.val);
                tmp.addAll(right.get(i));
                ans.add(tmp);
            }
        }
        return ans;
    }
}
