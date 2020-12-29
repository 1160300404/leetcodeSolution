package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution90 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> tmp=new ArrayList<>();
        Arrays.sort(num);
        dfs(num,0,ans,tmp);
        return ans;
    }
    public void dfs(int[] num,int start,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> tmp){
        ans.add(new ArrayList<>(tmp));
        for(int i=start;i<num.length;i++){
            if(i>start&&num[i]==num[i-1])
                continue;
            tmp.add(num[i]);
            dfs(num,i+1,ans,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
