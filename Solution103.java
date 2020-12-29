package Solution;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> stack=new Stack<>();
        int cnt=1;
        boolean reverse=true;
        stack.push(root);
        while(!stack.isEmpty()){
            List<Integer> tmp_ans=new ArrayList<>();
            Queue<TreeNode> queue=new LinkedList<>();
            while(cnt>0){
                TreeNode tmp=stack.pop();
                if(tmp!=null)
                    queue.offer(tmp);
                cnt--;
            }
            while(!queue.isEmpty()){
                TreeNode tmp=queue.poll();
                tmp_ans.add(tmp.val);
                if(!reverse){
                    stack.push(tmp.right);
                    stack.push(tmp.left);
                }else{
                    stack.push(tmp.left);
                    stack.push(tmp.right);
                }
            }
            reverse=!reverse;
            if(tmp_ans.size()>0)
                ans.add(tmp_ans);
            cnt=stack.size();
        }
        return ans;
    }
}
