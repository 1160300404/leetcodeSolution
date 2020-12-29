package Solution;

import java.util.Arrays;
import java.util.Stack;

//最大矩形
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int height=matrix.length;
        int length=matrix[0].length;
        int[] ht=new int[length];
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height;i++){
            stack.clear();
            int[] left=new int[length];
            int[] right=new int[length];
            Arrays.fill(right,length);
            for(int j=0;j<length;j++){
                if(matrix[i][j]=='1')
                    ht[j]+=1;
                else
                    ht[j]=0;
            }
            for(int j=0;j<length;j++){
                while(!stack.isEmpty()&&ht[j]<=ht[stack.peek()]){
                    right[stack.peek()]=j;
                    stack.pop();
                }
                left[j]=stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            for(int j=0;j<length;j++){
                max=Math.max(max,(right[j]-left[j]-1)*ht[j]);
            }
        }
        return max;
    }
}
