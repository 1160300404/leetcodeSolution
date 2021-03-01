/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从
矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵
的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径
（路径中的字母用加粗标出）。

 */
public class Solution_剑指Offer12_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int row,int col,int index){
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(index))
            return false;
        if(index==word.length()-1) return true;
        char tmp=board[row][col];
        board[row][col]='+';
        boolean res= dfs(board,word,row,col+1,index+1)||dfs(board,word,row,col-1,index+1)
        ||dfs(board,word,row+1,col,index+1)||dfs(board,word,row-1,col,index+1);
        board[row][col]=tmp;
        return res;
    }
}
