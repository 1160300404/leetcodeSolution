package Solution;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int cnt=1;
        while(!queue.isEmpty()){
            List<Integer> tmp_ans=new ArrayList<>();
            while(cnt>0){
                TreeNode tmp=queue.poll();
                if(tmp!=null){
                    tmp_ans.add(tmp.val);
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
                cnt--;
            }
            if(tmp_ans.size()>0)
                ans.add(0,tmp_ans);
            cnt=queue.size();
        }
        return ans;
    }
}
