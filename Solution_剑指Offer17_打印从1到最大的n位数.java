/*
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Solution_剑指Offer17_打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max=(int)Math.pow(10,n)-1;
        int[] ans=new int[max];
        for(int i=1;i<=max;i++){
            ans[i-1]=i;
        }
        return ans;
    }
}
