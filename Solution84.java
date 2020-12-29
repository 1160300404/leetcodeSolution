package Solution;

import java.util.Arrays;
import java.util.Stack;

// 柱状图中最大的矩形
public class Solution84 {
    public int largestRectangleArea (int[] height) {
        // write code here
        int length=height.length;
        int max=0;
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[length];
        int[] right=new int[length];
        Arrays.fill(right,length);
        for(int i=0;i<length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                right[stack.peek()]=i;
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        for(int i=0;i<length;i++){
            max=Math.max(max,(right[i]-left[i]-1)*height[i]);
        }
        return max;
    }
}
