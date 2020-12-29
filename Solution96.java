package Solution;

// 不同的二叉搜索树
public class Solution96 {
    public int numTrees(int n) {
        if(n<2)
            return 1;
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i = 2; i <= n; ++i){
            ans[i] = 0;
            for(int j = 1; j <= i; ++j){
                ans[i] += ans[j-1]*ans[i-j];
            }
        }
        return ans[n];
    }
}
