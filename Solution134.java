package Solution;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length=gas.length;
        if(length<0)
            return -1;
        int ans=0;
        int lack=0;
        int left=gas[ans];
        for(int i=1;i<length;i++){
            left=left-cost[i-1];
            if(left<0){
                ans=i;
                lack+=left;
                left=gas[i];
            }else{
                left+=gas[i];
            }
        }
        if(left+lack-cost[length-1]>=0){
            return ans;
        }
        return -1;
    }
}
