package Solution;


import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int length=ratings.length;
        if(length<1)
            return 0;
        int dp[]=new int[length]; //dp[i] means candy give to this child
        Arrays.fill(dp,1);
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        int ans = dp[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
            ans += dp[i];
        }
        return ans;
    }
}
