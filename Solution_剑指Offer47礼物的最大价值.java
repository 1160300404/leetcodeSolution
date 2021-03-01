public class Solution_剑指Offer47礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] dp=new int[n];
        int last=0;
        for(int i=0;i<m;i++){
            last=0;
            for(int j=0;j<n;j++){
                dp[j]=Math.max(last,dp[j])+grid[i][j];
                last=dp[j];
            }
        }
        return dp[n-1];
    }
}
