package Solution;

import java.util.Arrays;
import java.util.Comparator;

//435. 无重叠区间
/*
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() { //按照右端点排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int ans=1,right=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=right){
                ans++;
                right=intervals[i][1];
            }
        }
        return intervals.length-ans;
    }
}
