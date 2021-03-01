import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的
第 j 根糖果棒的大小。

因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。
（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
ans[1]是 Bob 必须交换的糖果棒的大小。

如果有多个答案，你可以返回其中任何一个。保证答案存在。

 */
public class Solution_888公平的糖果棒交换 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int ans[]=new int[2];
        ans[0]=-1;ans[1]=-1;
        Set<Integer> set=new HashSet<>();
        int sum_a=Arrays.stream(A).sum();
        int sum_b=Arrays.stream(B).sum();
        int target=(sum_a-sum_b)/2;
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }
        for(int i=0;i<B.length;i++){
            if(set.contains(B[i]+target)){
                ans[0]=A[B[i]+target];
                ans[1]=B[B[i]];
                return ans;
            }
        }
        return ans;
    }
}
