/*
给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数dividend除以除数divisor得到的商。

 */
public class Solution29_两数相除 {
    public int divide (int dividend, int divisor) {
        // write code here
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        int zheng=1,ans=0;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0))
            zheng=-1;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp) {
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            ans+=c;
        }
        return zheng*ans;
    }
}
