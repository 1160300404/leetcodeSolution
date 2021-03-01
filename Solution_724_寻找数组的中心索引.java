/*
给定一个整数类型的数组nums，请编写一个能够返回数组 “中心索引” 的方法。

我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */
public class Solution_724_寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int left=0,right=0;
        for(int i=1;i<nums.length;i++){
            right+=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            if(left==right) return i;
            left+=nums[i];
            right-=nums[i+1];
        }
        if(right==left) return nums.length-1;
        return -1;
    }
}
