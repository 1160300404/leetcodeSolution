/*
实现函数double Power(double base, int exponent)，求base的exponent次方。
不得使用库函数，同时不需要考虑大数问题。

 */
public class Solution_剑指Offer16_数值的整数次方 {
    public double myPow(double x, int n) {
        double ans=1.0;
        double tmp=x;
        boolean reverse=false;
        if(n<0){
            if(n==Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                ans=x;
            }else{
                n=Math.abs(n);
            }
            reverse=true;
        }
        while(n>0){
            if(n%2==1) ans=(ans*x);
            x=x*x;
            n/=2;
        }
        if(reverse) return 1/ans;
        return ans;
    }
}
