/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Solution152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int ans=nums[0];
        int lastmax=nums[0];
        int lastmin=nums[0];
        for(int i=1;i<nums.length;i++){
            int lmx=lastmax;
            int lmn=lastmin;
            lastmax=Math.max(nums[i],Math.max(lmx*nums[i],lmn*nums[i]));
            lastmin=Math.min(nums[i],Math.min(lmx*nums[i],lmn*nums[i]));
            if(lastmax>ans) ans=lastmax;
        }
        return ans;
    }
}
