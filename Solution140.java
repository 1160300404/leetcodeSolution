package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int strlength=s.length();
        int diclength=wordDict.size();
        //List<String> ans=new ArrayList<>();
        Set<String> wordset=new HashSet<>(wordDict);
        int dp[]=new int[strlength+1];
        dp[0]=1;
        //dp[i] 代表在第i个字符处可以匹配多少个word
        for(int i=1;i<=strlength;i++){
            for(int j=0;j<i;j++){
                if (dp[j]>0 && wordset.contains(s.substring(j, i)))
                {
                    dp[i]+=1;
                }
            }
        }
        if(dp[strlength]==0){
            return new ArrayList<>();
        }
        return bfs(strlength,dp,diclength,wordDict,s);
    }
    private List<String> bfs(int index,int[] dp,int diclength,List<String> wordDict,String s){
        List<String> ans=new ArrayList<>();
        if(index==0){
            ans.add("");
            return ans;
        }
        for(int i=0;i<diclength;i++){
            String word=wordDict.get(i);
            if(index>=word.length()&&word.equals(s.substring(index-word.length(),index))&&dp[index-word.length()]>0){
                List<String> tmp=bfs(index-word.length(),dp,diclength,wordDict,s);
                for(int j=0;j<tmp.size();j++){
                    String strtmp=tmp.get(j);
                    if(index==s.length())
                        tmp.set(j,strtmp+word);
                    else
                        tmp.set(j,strtmp+word+" ");
                }
                ans.addAll(tmp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="asdas";
        s=s+'a';
        System.out.println(s);
    }
}
