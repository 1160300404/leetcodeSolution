package Solution;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution102 {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int cnt=1;
        while(!queue.isEmpty()){
            ArrayList<Integer> tmp=new ArrayList<>();
            while(cnt>0){
                TreeNode node=queue.poll();
                if(node!=null){
                    tmp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                cnt--;
            }
            cnt=queue.size();
            if(tmp.size()>0)
                ans.add(tmp);
        }
        return ans;
    }
}
