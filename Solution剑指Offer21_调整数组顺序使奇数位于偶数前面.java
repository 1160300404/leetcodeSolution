public class Solution剑指Offer21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]%2==1){
                left++;
            }else if(nums[right]%2==0){
                right--;
            }else {
                int tmp=nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
