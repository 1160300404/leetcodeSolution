/*
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class Solution_643子数组最大平均数 {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        double ans=0.0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        ans=(double)sum/k;
        for(int i=k;i<nums.length;i++){
            int tmp_sum=sum-nums[k-1]+nums[k];
            if(tmp_sum>sum){
                sum=tmp_sum;
                ans=(double)sum/k;
            }
        }
        return ans;
    }
}
