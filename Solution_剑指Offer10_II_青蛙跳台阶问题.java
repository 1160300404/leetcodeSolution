/*

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution_剑指Offer10_II_青蛙跳台阶问题 {
    public int numWays(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        int last=1;
        int lastlast=1;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=(last+lastlast)%1000000007;
            lastlast=last;
            last=ans;
        }
        return ans;
    }
}
