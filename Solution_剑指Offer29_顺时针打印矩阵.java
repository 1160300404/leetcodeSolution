/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Solution_剑指Offer29_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new int[0];
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        int col=matrix[0].length;
        int count=matrix.length*matrix[0].length;
        int[] ans=new int[count];
        int index=0;
        while(index<count){
            for(int i=left;i<=right;i++){
                ans[index]=matrix[top][i];
                index++;
            }
            for(int i=top+1;i<=bottom;i++){
                ans[index]=matrix[i][right];
                index++;
            }
            if(bottom>top)
                for(int i=right-1;i>=left;i--){
                    ans[index]=matrix[bottom][i];
                    index++;
                }
            if(right>left)
                for(int i=bottom-1;i>=top+1;i--){
                    ans[index]=matrix[i][left];
                    index++;
                }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }
}
