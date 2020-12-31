package Solution;
/*
给出一个转动过的有序数组，你事先不知道该数组转动了多少
(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
假设数组中不存在重复项。
 */
public class 在转动过的有序数组中寻找目标值 {
    public int search (int[] A, int target) {
        // write code here
        if (A.length==0)
            return -1;
        int lo = 0, hi = A.length - 1;

        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            if (A[mi] == target)
                return mi;

            // 只要在普通的二分查找判断语句中加一层 && 来确定目标值所在的区间，即可以同样O(logn)的复杂度查找
            if (A[lo] <= A[mi] && (A[lo] <= target && target < A[mi]))
                hi = mi - 1;
            else if (A[mi] <= A[hi] && !(A[mi] < target && target <= A[hi]))
                hi = mi - 1;
            else
                lo = mi + 1;
        }
        return -1;
    }
}
