package Solution;


class Solution283 {
    public void moveZeroes(int[] nums) {
        int firstzero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                firstzero=i;
                break;
            }
        }
        int indexnozero=findnozero(nums,0,firstzero);
        if(indexnozero==-1){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[indexnozero];
                nums[indexnozero]=tmp;
                indexnozero=findnozero(nums,indexnozero,i);
                if(indexnozero==-1){
                    break;
                }
            }
        }
    }
    public int findnozero(int[] nums,int indexnozero,int zero){
        for(int i=indexnozero;i<nums.length;i++){
            if(nums[i]!=0&&i>zero){
                indexnozero=i;
                return indexnozero;
            }
        }
        return -1;
    }
}
