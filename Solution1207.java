package Solution;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int tmp=map.get(arr[i]);
                map.put(arr[i],tmp+1);
            }else{
                map.put(arr[i],1);
            }
        }
        Set<Integer> set= map.keySet();
        map.clear();
        for(int key:set){
            if(map.containsKey(key)){
                return false;
            }else{
                map.put(key,1);
            }
        }
        return true;
    }
}
