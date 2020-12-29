package Solution;

import java.util.HashMap;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            result[1]=i;
            if(map.containsKey((target-nums[i]))){
                result[0]=map.get(target-nums[i]);
                return result;
            }else {
                map.put(nums[i],i);
            }
        }
        return  result;
    }
}
