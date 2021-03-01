public class Solution_剑指Offer56_II数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        int[] cnt=new int[32];
        for(int i=0;i<nums.length;i++){
            int j=0,num=nums[i];
            while(num!=0){
                if((num&1)==1)
                    cnt[j]++;
                num=num>>1;
                j++;
            }
        }
        int ans=0;
        for(int i=31;i>=0;i--){
            ans=ans<<1;
            ans=ans+cnt[i]%3;
        }
        return ans;
    }
}
