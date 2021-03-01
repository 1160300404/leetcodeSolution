/*
统计一个数字在排序数组中出现的次数。
 */
public class Solution剑指Offer53_I在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        int length=0;
        int left=0,right=nums.length-1,tart_start=-1;
        int left2=0,right2=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(tart_start==-1&&nums[mid]==target){
                tart_start=mid;
            }
            if(nums[mid]>=target){
                right--;
            }else {
                left++;
            }
        }
        if(tart_start==-1) return 0;
        while (left2<=right2){
            int mid=(left2+right2)/2;
            if(nums[mid]<=target){
                left2++;
            }else {
                right2--;
            }
        }
        return left2-left;

    }
}
