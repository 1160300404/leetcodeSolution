
public class Solution_剑指Offer13机器人的运动范围 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs(visited,0,0,k);
    }
    public int dfs(boolean[][] visited, int row,int col,int k){
        if(!canvisited(visited,row,col,k))
            return 0;
        visited[row][col]=true;
        int res=1+dfs(visited,row,col+1,k)+dfs(visited,row,col-1,k)
                +dfs(visited,row+1,col,k)+dfs(visited,row-1,col,k);
        return res;
    }
    public boolean canvisited(boolean[][] visited, int row,int col,int k){
        int tmp=0;
        if(row<0||row>=visited.length||col<0||col>=visited[0].length||visited[row][col])
            return false;
        while(row>0){
            tmp+=row%10;
            row/=10;
        }
        while(col>0){
            tmp+=col%10;
            col/=10;
        }
        if(tmp>k){
           return false;
        }
        return true;
    }
}
