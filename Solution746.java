package Solution;

//使用最小花费爬楼梯

/***
 * 数组的每个索引作为一个阶梯，第i个阶梯对应着一个非负数的体力花费cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0)
            return 0;
        else if(cost.length==1)
            return cost[0];
        int[] dp=new int[cost.length];
        dp[0]=cost[0];dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
