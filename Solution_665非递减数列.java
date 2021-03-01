/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，
该数组能否变成一个非递减数列。


 */
public class Solution_665非递减数列 {
    public boolean checkPossibility(int[] nums) {
        if(nums.length==1) return true;
        int chance=1;
        if(nums[0]>nums[1]) {
            nums[0] = nums[1];
            chance--;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(chance==0) return false;
                nums[i]=nums[i-1];
                chance--;
            }
        }
        return true;
    }
}
