package Solution;

//36. 有效的数独
/*
判断一个  9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字  1-9  在每一行只能出现一次。
数字  1-9  在每一列只能出现一次。
数字  1-9  在每一个以粗实线分隔的  3x3  宫内只能出现一次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowVisited = new boolean[9][9];
        boolean[][] colVisited = new boolean[9][9];
        boolean[][] blockVisited = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                int num = c - '0' - 1;
                if(rowVisited[i][num] || colVisited[j][num] || blockVisited[i / 3 * 3 + j / 3][num]){
                    return false;
                }
                rowVisited[i][num] = true;
                colVisited[j][num] = true;
                blockVisited[i / 3 * 3 + j / 3][num] = true;
            }
        }
        return true;
    }
}
