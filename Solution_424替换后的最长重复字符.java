import java.util.Arrays;

/*
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，
总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过104。
 */
public class Solution_424替换后的最长重复字符 {
    public int characterReplacement(String s, int k) {
        int ans=0,max=0,left=0,length=s.length()-1,right=0;
        int[] array=new int[26];
        while(left<=length-ans){
            while(right<=length){
                char c=s.charAt(right);
                array[c-'A']++;
                max=Math.max(max,array[c-'A']);
                int tmp=right-left+1-max;
                if(tmp<=k){
                    ans=right-left+1;
                    right++;
                }else{
                    right++;
                    break;
                }
            }
            array[s.charAt(left)-'A']--;
            left++;
        }
        return ans;
    }
}
