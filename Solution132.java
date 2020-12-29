package Solution;

public class Solution132 {
    public int minCut(String s) {
        int length=s.length();
        if(length<2)
            return 0;
        boolean dp[][]=new boolean[length][length];
        for(int right=0;right<length;right++){
            for(int left=0;left<right;left++){
                if(s.charAt(left)==s.charAt(right)&&((right-left)<=2||dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }
        int fnt[][]=new int[length][length];
        for(int t=0;t<=s.length();t++)
            for(int left=0,right=t;right<length;right++,left++){
                if(dp[left][right]) fnt[left][right]=0;
                else{
                    int min=right-left+1;
                    for(int i=left;i<right;i++){
                        int tmp=fnt[left][i]+fnt[i+1][right]+1;
                        if(tmp<min){
                            min=tmp;
                        }
                        fnt[left][right]=min;
                    }
                }
                if(s.charAt(left)==s.charAt(right)&&((right-left)<=2||dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        return fnt[0][length-1];
    }

}
