package Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

//239. 滑动窗口最大值
/*
给你一个整数数组 nums，有一个大小为  k  的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k  个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 */
public class Solution239 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1]-o2[1];
                }
            });
            int length=nums.length;
            int[] ans=new int[length-k+1];
            for(int i=0;i<k;i++){
                queue.offer(new int[]{i,nums[i]});
            }
            if(!queue.isEmpty()) ans[0]=queue.peek()[1];
            for(int i=k;i<length;i++){
                queue.offer(new int[]{i,nums[i]});
                while(queue.peek()[0]<=i-k){
                    queue.poll();
                }
                ans[i-k+1]=queue.peek()[1];
            }
            return  ans;
        }
}
