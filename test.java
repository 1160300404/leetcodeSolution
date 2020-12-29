package Solution;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class test {
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
                    System.out.printf("%d %d %d %d %d\n",i,j,stack.peek(),ht[j],ht[stack.peek()]);
                    right[stack.peek()]=j;
                    stack.pop();
                }
                left[j]=stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            for(int j=0;j<length;j++){
                max=Math.max(max,(right[j]-left[j]-1)*ht[j]);
                //System.out.printf("%d %d %d %d\n",right[j],left[j],ht[j],max);
            }
        }
        System.out.println(max);
        return max;
    }

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
        if(i<0||i>m||j<0||j>n||board[i][j]!=word.charAt(cnt))
            return false;
        else{
            char tmp=board[i][j];
            board[i][j]='0';
            boolean ans=dfs(board,word,i-1,j,cnt+1,m,n)||dfs(board,word,i,j-1,cnt+1,m,n);
            ans=ans||dfs(board,word,i+1,j,cnt+1,m,n)||dfs(board,word,i,j+1,cnt+1,m,n);
            board[i][j]=tmp;
            return ans;
        }
    }

    public static void main(String[] args) {
        char a='a'+5+6;
        System.out.println(a);
    }

}
