package Solution;

import java.util.ArrayList;
import java.util.HashMap;

//参议院
public class Solution649 {
    public String predictPartyVictory(String senate) {
        int r=0, d=0;
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                r++;
                continue;
            }
            d++;
        }
        while(r!=0&&d!=0){
            char[] chars=senate.toCharArray();
            int length=senate.length();
            for(int i=0;i<length;i++) {
                char reverse;
                if(chars[i]=='R'){
                    reverse='D';d--;
                    if(d==0) return "Radiant";
                }else if(chars[i]=='D'){
                    reverse='R'; r--;
                    if(r==0) return  "Dire";
                }else{
                    continue;
                }
                int j;
                for(j=i+1;j<length;j++){
                    if(chars[j]==reverse){
                        chars[j]='0';break;
                    }
                }
                if(j==length){
                    for(j=0;j<i-1;j++){
                        if(chars[j]==reverse){
                            chars[j]='0';break;
                        }
                    }
                }
            }
            senate="";
            for(int i=0;i<length;i++){
                if(chars[i]!='0') senate+=chars[i];
            }
            System.out.println(senate);
        }
        return r==0?"Dire":"Radiant";
    }

    public static void main(String[] args) {
        Solution649 s=new Solution649();
        System.out.println(s.predictPartyVictory("RD"));
    }
}
