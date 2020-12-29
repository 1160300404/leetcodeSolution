package Solution;

import java.util.HashMap;

public class Solution128 {
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i:num) map.put(i,1);
        for(int i:num){
            if(map.getOrDefault(i,0)!=0){
                int tmp=1;
                int number=i+1;
                while(map.containsKey(number)){
                    map.put(number,0);
                    tmp++;
                    number++;
                }
                number=i-1;
                while(map.containsKey(number)){
                    map.put(number,0);
                    tmp++;
                    number--;
                }
                ans=Math.max(tmp,ans);
            }
        }
        return ans;
    }
}
