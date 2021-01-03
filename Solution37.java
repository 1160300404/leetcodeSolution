package Solution;

// 解数独
/*
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字  1-9  在每一行只能出现一次。
数字  1-9  在每一列只能出现一次。
数字  1-9  在每一个以粗实线分隔的  3x3  宫内只能出现一次。

 */
public class Solution37 {
    boolean[][] rows=new boolean[9][9];
    boolean[][] cols=new boolean[9][9];
    boolean[][] cubes=new boolean[9][9];
    public void solveSudoku(char[][] board) {
        if(board==null||board.length==0) return;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int cube=i / 3 * 3 + j / 3;
                    char tmp=board[i][j];
                    rows[i][tmp-'1']=cols[j][tmp-'1']=cubes[cube][tmp-'1']=true;
                }

            }
        }
        dfs(board,0);
    }
    public boolean dfs(char[][] board,int num){
        if(num==81)
            return true;
        int row=num/9;
        int col=num%9;
        int cube=row / 3 * 3 + col / 3;
        char tmp=board[row][col];
        if(tmp!='.'){
            return dfs(board,num+1);
        }
        for(char c='1';c<='9';c++){
            if(rows[row][c-'1']||cols[col][c-'1']||cubes[cube][c-'1'])
                continue;
            board[row][col]=c;rows[row][c-'1']=cols[col][c-'1']=cubes[cube][c-'1']=true;
            if(dfs(board,num+1))
                return true;
            board[row][col]='.';rows[row][c-'1']=cols[col][c-'1']=cubes[cube][c-'1']=false;
        }
        return false;
    }
}
