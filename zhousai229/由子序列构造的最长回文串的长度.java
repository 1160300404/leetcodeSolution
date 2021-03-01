package zhousai229;

public class 由子序列构造的最长回文串的长度 {
    public int longestPalindrome(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int l3=l1+l2;
        int[][] dp=new int[l3][l3];
        String word3=word1+word2;
        int ans=(word3.charAt(l1-1)==word3.charAt(l1)?2:0);
        for(int i=0;i<l3;i++){
            dp[i][i]=1;
        }
        for(int i=0;i<l3-1;i++){
            dp[i][i+1]=(word3.charAt(i)==word3.charAt(i+1)?2:1);
        }
        for(int len=2;len<l3;len++){
            for(int i=0;i<l3-len;i++){
                int r=i+len;
                if(word3.charAt(i)==word3.charAt(r)){
                    dp[i][r]=dp[i+1][r-1]+2;
                    if(i<l1&&r>=l1){
                        ans=Math.max(ans,dp[i][r]);
                    }
                }else{
                    dp[i][r]=Math.max(dp[i+1][r],dp[i][r-1]);
                }
            }
        }
        return ans;
    }
}
