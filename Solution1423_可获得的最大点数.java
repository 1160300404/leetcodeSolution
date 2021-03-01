import java.util.Arrays;

/*
几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。

每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。

你的点数就是你拿到手中的所有卡牌的点数之和。

给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。。
 */
public class Solution1423_可获得的最大点数 {
    public int maxScore(int[] cardPoints, int k) {
        k=cardPoints.length-k;
        int sum=0,ans=0;
        int all= Arrays.stream(cardPoints).sum();
        int left=0,right=k-1;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        ans=sum;
        while (right<cardPoints.length){
            sum=sum-cardPoints[left--]+cardPoints[++right];
            if(sum<ans){
                ans=sum;
            }
        }
        return all-ans;
    }
}
