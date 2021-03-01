/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。
 */
public class Solution_剑指Offer42连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        int last=0,ans=nums[0];
        for(int i=0;i<nums.length;i++){
            if(last>0){
                last=nums[i]+last;
            }else {
                last=nums[i];
            }
            ans=Math.max(ans,last);
        }
        return ans;
    }
}
