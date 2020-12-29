package Solution;

// 单词搜索
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m<1)
            return word.length()==0?true:false;
        int n=board[0].length;
        if(n<1)
            return word.length()==0?true:false;
        boolean ans=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=ans||dfs(board,word,i,j,0,m,n);
            }
        }
        return ans;
    }
    public boolean dfs(char[][] board,String word,int i,int j,int cnt,int m, int n){
        if(i<0||i>=m||j<0||j>=n||board[i][j]!=word.charAt(cnt))
            return false;
        else{
            if(cnt==word.length()-1)
                return true;
            char tmp=board[i][j];
            board[i][j]='0';
            boolean ans=dfs(board,word,i-1,j,cnt+1,m,n)||dfs(board,word,i,j-1,cnt+1,m,n);
            ans=ans||dfs(board,word,i+1,j,cnt+1,m,n)||dfs(board,word,i,j+1,cnt+1,m,n);
            board[i][j]=tmp;
            return ans;
        }
    }
}
