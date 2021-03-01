public class Solution剑指Offer53_II0到n_1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(mid==nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
