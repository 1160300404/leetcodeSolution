import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_1052_爱生气的书店老板 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans= 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0||i<X){
                ans+=customers[i];
            }
        }
        int left=1,right=X;
        while(right<customers.length){
            int tmp=ans;
            if(grumpy[right]==1) tmp+=customers[right];
            if(grumpy[left-1]==1) tmp-=customers[left-1];
            ans=Math.max(ans,tmp);
            left++;
            right++;
        }
        return ans;
    }
}
