public class Solution_剑指Offer04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0) return false;
        int col=matrix[0].length;
        if(col==0) return false;
        int index_row=0;
        int index_col=col-1;
        while(index_col>0&&index_row<row){
            if(target==matrix[index_row][index_col]){
                return true;
            }else if(target>matrix[index_row][index_col]){
                index_row++;
            }else{
                index_col--;
            }
        }
        return false;
    }
}
