package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution738 {
    public int monotoneIncreasingDigits(int N){
        LinkedList<Integer> list=new LinkedList<>();
        int ans=0,pre=N%10,cnt=1,index=0,count=1;
        N=N/10;
        while(N>0){
            int now=N%10;
            if(pre<now){
                index=count;
                pre=9;
                now-=1;
            }
            count++;
            N=N/10;
            list.addFirst(pre);
            pre=now;
            cnt*=10;
        }
        list.addFirst(pre);
        System.out.println(list);
        for(int i=0;i<list.size()-index;i++){
            ans=ans*10+list.get(i);
        }
        for(int i=0;i<index;i++){
            ans=ans*10+9;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution738 s=new Solution738();
        s.monotoneIncreasingDigits(231);
    }
}
