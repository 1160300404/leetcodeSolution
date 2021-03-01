/*
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Solution_剑指Offer57和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(right>left){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[]{nums[left],nums[right]};
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[0];
    }
}
