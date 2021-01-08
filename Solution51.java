package Solution;

import java.util.ArrayList;
import java.util.Arrays;

// n皇后
public class Solution51 {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ans=new ArrayList<>();
        int[] col=new int[n],row=new int[n],xie1=new int[2*n],xie2=new int[2*n],pailie=new int[n];
        Arrays.fill(pailie,-1);
        dfs(ans,n,0,pailie,col,row,xie1,xie2);
        return  ans;
    }
    public void  dfs(ArrayList<String[]> ans,int n,int index,int[] pailie,int[] col,int[] row,int[] xie1,int[] xie2){
        if(n==index){
            String[] tmp=generate(pailie);
            ans.add(tmp);
            return;
        }
        for(int i=0;i<n;i++){
            if((col[i]+row[index]+xie1[i+index]+xie2[index-i+n])==0){
                col[i]=row[index]=xie1[i+index]=xie2[index-i+n]=1;
                pailie[index]=i;
                dfs(ans,n,index+1,pailie,col,row,xie1,xie2);
                col[i]=row[index]=xie1[i+index]=xie2[index-i+n]=0;
                pailie[index]=-1;
            }
        }
    }
    public String[] generate(int[] pailie){
        int n=pailie.length;
        String[] ans=new String[n];
        for(int i=0;i<n;i++){
            String tmp="";
            for(int j=0;j<n;j++){
                if(j==pailie[i]) tmp+="Q";
                else tmp+=".";
            }
            ans[i]=tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution51 s=new Solution51();
        ArrayList<String[]> test=s.solveNQueens(8);
        for(int i=0;i<test.size();i++){
            for(int j=0;j<test.get(i).length;j++){
                System.out.println(test.get(i)[j]);
            }
            System.out.println("  ");
        }

    }
}
