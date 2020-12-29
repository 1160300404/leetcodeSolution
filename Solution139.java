package Solution;

import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int strlength=s.length();
        int diclength=wordDict.size();
        //dp[i] True means string can split into wordDict when string length is i+1
        boolean dp[]=new boolean[strlength+1];
        dp[0]=true;
        for(int i=1;i<strlength;i++) {
            for (int j = 0; j < diclength; j++) {
                String word = wordDict.get(j);
                if (i < word.length()) {
                    continue;
                }
                 else{
                    dp[i] = dp[i] || (dp[i - word.length()] && ifcansplit(s, i, word));
                }
            }

        }
        return dp[strlength];
    }
    private boolean ifcansplit(String s,int index,String word){
        return  word.equals(s.substring(index-word.length(),index));
    }
}
