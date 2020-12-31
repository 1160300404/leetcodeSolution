package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//39. 组合总和
/*
给定一个无重复元素的数组  candidates  和一个目标数  target  ，找出  candidates  中所有可以使数字和为  target  的组合。

candidates  中的数字可以无限制重复被选取。

说明：

所有数字（包括  target）都是正整数。
解集不能包含重复的组合。  

 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length <= 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        dfs(ans,tmp,candidates,0,target);
        return ans;
    }
    public  void dfs(List<List<Integer>> ans,List<Integer> tmp,int[] num,int index,int target){
        if(target==0){
            List<Integer> tmp_ans=new ArrayList<>(tmp);
            if(!ans.contains(tmp_ans))
                ans.add(tmp_ans);
            return;
        }
        for(int i=index;i<num.length;i++){
            if(num[i]<=target){
                tmp.add(num[i]);
                dfs(ans,tmp,num,i,target-num[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
