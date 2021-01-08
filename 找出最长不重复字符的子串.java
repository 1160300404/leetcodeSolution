package leetcode;

import java.util.HashSet;

public class 找出最长不重复字符的子串 {
    public int lengthOfLongestSubstring (String s) {
        // write code here
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0,ans=0;
        for(left=0;left<s.length();left++){
            for(right=left;right<s.length();right++){
                if(set.contains(s.charAt(right))){
                    ans=Math.max(ans,right-left);
                    break;
                }else{
                    set.add(s.charAt(right));
                }
            }
            set.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        找出最长不重复字符的子串 s=new 找出最长不重复字符的子串();
        int a =s.lengthOfLongestSubstring("pwwkew");
        System.out.println(a);
    }
}
