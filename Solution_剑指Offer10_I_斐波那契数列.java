/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0, F(1)= 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Solution_剑指Offer10_I_斐波那契数列 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int last=1;
        int lastlast=0;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=(last+lastlast)%1000000007;
            lastlast=last;
            last=ans;
        }
        return ans;
    }
}
