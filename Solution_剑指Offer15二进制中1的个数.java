/*
请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，
把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。


 */
public class Solution_剑指Offer15二进制中1的个数 {
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
