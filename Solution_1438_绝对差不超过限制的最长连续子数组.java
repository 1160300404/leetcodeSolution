import sun.awt.image.ImageWatched;
import java.util.Queue;

import java.util.LinkedList;

public class Solution_1438_绝对差不超过限制的最长连续子数组 {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> big=new LinkedList<>();
        LinkedList<Integer> small=new LinkedList<>();
        int left=0,right=0,ans=0;
        while(right<nums.length){
            while (!big.isEmpty()&&nums[right]> big.getLast()){
                    big.removeLast();
            }
            big.addLast(nums[right]);
            while (!small.isEmpty()&&nums[right]< small.getLast()){
                small.removeLast();
            }
            small.addLast(nums[right]);
            while(big.peek()-small.peek()>limit){
                left++;
                if(big.peek()==nums[left]) big.poll();
                if(small.peek()==nums[left]) small.poll();
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
