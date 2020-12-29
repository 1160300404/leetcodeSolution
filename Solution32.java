package Solution;

// 最长有效括号
public class Solution32 {
    public int longestValidParentheses (String s) {
        // write code here
        int ans=0;
        int[] dp=new int[s.length()+1];
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)==')'){
                int tmp=dp[i-1];
                int index=i-1-tmp;
                if(index>0&&s.charAt(index-1)=='('){
                    dp[i]=tmp+2+dp[index-1];
                }
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
