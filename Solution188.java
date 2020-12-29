package Solution;


public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        k=k>prices.length-1?prices.length-1:k;
        int ans=0;
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][0]=-prices[i];
        }
        int[] lastRoundSell=new int[prices.length];
        for(int i=1;i<=k;i++){
            for(int j=i;j<prices.length;j++){
                dp[j][0]=Math.max(dp[j-1][0],lastRoundSell[j]-prices[j]);
                dp[j][1]=Math.max(dp[j-1][1],dp[j][0]+prices[j]);
                lastRoundSell[j]=dp[j][1];

            }
        }
        for(int i=0;i<prices.length;i++){
            if(dp[i][1]>ans){
                ans=dp[i][1];
            }
        }
        return ans;
    }
}
