package zhousai229;

public class 执行乘法运算的最大分数 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length,m=multipliers.length;
        int[][] dp=new int[m+1][m+1];
        dp[1][0] = nums[0] * multipliers[0];
        dp[0][1] = nums[nums.length - 1] * multipliers[0];
        for(int i=2;i<=m;i++){
            int mul = multipliers[i - 1];
            for(int k=0;k<=i;k++ ){
                int r = i - k;
                int nums_index = nums.length - (i - k);
                if(k==0){
                    dp[k][r]=dp[k][r-1]+mul*nums[nums_index];
                    continue;
                }
                if(r==0){
                    dp[k][r]=dp[k-1][r]+mul*nums[k-1];
                    continue;
                }
                dp[k][r] = Math.max(dp[ k- 1][r] + mul * nums[k - 1],dp[k][r - 1] + mul * nums[nums_index]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i <= m;i++){
            ans = Math.max(dp[i][m - i],ans);
        }
        return ans;
    }
}
