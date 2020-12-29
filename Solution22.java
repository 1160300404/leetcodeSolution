package Solution;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Solution22 {
    public List<String> generateParenthesis (int n) {
        // write code here
        List<String> ans=new ArrayList<String>();
        int left=n,right=n;
        dfs(new StringBuilder(),left,right,n,ans);
        return ans;
    }
    public void dfs(StringBuilder cur,int left,int right,int max, List<String> ans){
        if(cur.length()==2*max){
            ans.add(cur.toString());
            return ;
        }
        if(left>0){
            cur.append('(');
            dfs(cur,left-1,right,max,ans);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(right-left>0){
            cur.append(')');
            dfs(cur,left,right-1,max,ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
