package Solution;

import java.util.Arrays;

public class Solution164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while(maxVal>exp){
            int[] cnt=new int[10];
            for(int i=0;i<n;i++){
                int dig=(nums[i]/(int)exp)%10;
                cnt[dig]++;
            }
            for(int i=1;i<n;i++){
                cnt[i]+=cnt[i-1];
            }
            for(int i=n-1;i>=0;i--){
                int dig=(nums[i]/(int)exp)%10;
                buf[cnt[i]--]=nums[i];
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }
        int ans=0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
}
