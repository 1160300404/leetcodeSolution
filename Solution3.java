package Solution;


import java.util.HashMap;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int reuslt=1;
        int index=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int tmp=map.getOrDefault(s.charAt(i),-1);
            if(tmp>=index){
                reuslt=Math.max(reuslt,i-index);
                index=tmp+1;
            }
            map.put(s.charAt(i),i);
        }
        reuslt=Math.max(reuslt,s.length()-index);
        System.out.println(index);
        return reuslt;
    }
}
