package Solution;
import java.util.ArrayList;
import java.util.Arrays;

//加起来和为目标值的组合
/*
给出一组候选数  C 和一个目标数   T，找出候选数中起来和等于   T 的所有组合。
  C 中的每个数字在一个组合中只能使用一次。
注意：
题目中所有的数字（包括目标数   T ）都是正整数
组合中的数字 要按非递减排序
结果中不能包含重复的组合
组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引
 */
public class Solution40 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null || num.length <= 0) return null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp=new ArrayList<>();
        dfs(ans,tmp,num,0,target);
        return ans;
    }
    public  void dfs(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> tmp,int[] num,int index,int target){
        if(target==0){
            ArrayList<Integer> tmp_ans=new ArrayList<>(tmp);
//             System.out.println(tmp_ans);
            if(!ans.contains(tmp_ans))
                ans.add(tmp_ans);
            return;
        }
        for(int i=index;i<num.length;i++){
            if(num[i]<=target){
                tmp.add(num[i]);
                dfs(ans,tmp,num,i+1,target-num[i]);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
