package Solution;

public class Solution115 {
    public int numDistinct(String s, String t) {
        int index=0;
        int S=s.length();
        int T=t.length();
        int[][] dp=new int[S+1][T+1];
        dp[0][0]=1;
        for(int i=0;i<=S;i++) dp[i][0]=1;
        for(int i=1;i<=S;i++){
            for(int j=1;j<=T;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[S][T];
    }
}
