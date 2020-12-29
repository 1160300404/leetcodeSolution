package Solution;

import java.util.ArrayList;
import java.util.List;

// 组合
public class Solution77 {
    public List<List<Integer>> combine (int n, int k) {
        // write code here
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> tmp= new ArrayList<Integer>();
        dfs(1,n,k,ans,tmp);
        return ans;
    }
    public void dfs(int start ,int n ,int k,List<List<Integer>> ans,List<Integer> tmp){
        if(tmp.size()==k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            dfs(i+1,n,k,ans,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
