package leetcode;

import java.util.HashMap;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map=new HashMap<>();
        String[] s_list=s.split(" ");
        if(pattern.length()!=s_list.length)
            return  false;
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(map.containsKey(s_list[i])&&map.get(s_list[i])!=c)
                return false;
            if(map1.containsKey(c)&&!map1.get(c).equals(s_list[i]))
                return false;
            if(!map.containsKey(s_list[i])){
                map.put(s_list[i],c);
            }
            if(!map1.containsKey(c)){
                map1.put(c,s_list[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(-3126%10);
    }
}
