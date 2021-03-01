import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。
 */
public class Solution_567字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> map1=new HashMap<>();
        int length_1=s1.length(),length_2=s2.length();
        for(int i=0;i<length_1;i++){
            char c_1=s1.charAt(i),c_2=s2.charAt(i);
            map.put(c_1,map.getOrDefault(c_1,0));
            map1.put(c_2,map1.getOrDefault(c_2,0));
        }
        if(map.equals(map1)) return true;
        for(int i=length_1;i<length_2;i++){
            char old=s2.charAt(i+1-length_1),c_2=s2.charAt(i);
            int count=map1.get(old)-1;
            if(count==0) {
                map1.remove(old);
            }else {
                map1.put(old,count);
            }
            map1.put(c_2,map1.getOrDefault(c_2,0));
            if(map.equals(map1)) return true;
        }
        return false;
    }
}
