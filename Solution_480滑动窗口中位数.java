import javafx.util.Pair;

import java.util.PriorityQueue;

/*
中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；
此时中位数是最中间的两个数的平均数。

给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，
每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，
并输出由它们组成的数组。

 */
public class Solution_480滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer,Integer>> queue=new PriorityQueue<>();

        if(nums.length<=0) return new double[0];
        int length=nums.length-k+1;
        int[] mids={k/2,(k-1)/2};
        double[] ans=new double[length];
        for(int i=0;i<length;i++){
            int mid1=nums[i+mids[0]];
            int mid2=nums[i+mids[1]];
            ans[i]=((double)(mid1+mid2))/2;
        }
        return ans;
    }
}
