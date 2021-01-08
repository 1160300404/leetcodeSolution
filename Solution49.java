package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] arry=strs[i].toCharArray();
            Arrays.sort(arry);
            String tmp=new String(arry);
            if(!map.containsKey(tmp)) map.put(tmp,new ArrayList<>());
            map.get(tmp).add(strs[i]);
        }
        for(String s:map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}
