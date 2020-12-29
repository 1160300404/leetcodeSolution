package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 换位词 {
//    public ArrayList<String> anagrams(String[] strs) {
//        ArrayList<String> ans=new ArrayList<>();
//        HashMap<Integer,int[]> map=new HashMap<>(); //store str not anagrams
//        boolean flag=false;
//        for(int i=0;i<strs.length;i++){
//            int[] chars=new int[26];
//            String str=strs[i];
//            for(int j=0;j<str.length();j++){
//                chars[str.charAt(j)-'a']++;
//            }
//            for(int index:map.keySet()){
//                flag=true;
//                int[] list=map.get(index);
//                for(int k=0;k<26;k++){
//                    if(list[k]!=chars[k]){
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag){
//                    if(!ans.contains(strs[index])) ans.add(strs[index]);
//                    ans.add(str); break;
//                }
//            }
//            if(!flag){
//                map.put(i,chars);
//            }
//        }
//        System.out.println(ans);
//        return ans;
//    }
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> map=new HashMap<>(); //store str not anagrams
        for(int i=0;i<strs.length;i++){
            char[] tmp=strs[i].toCharArray();
            Arrays.sort(tmp);
            String new_Str=String.valueOf(tmp);
            if(!map.containsKey(new_Str)) map.put(new_Str,new ArrayList<>());
            map.get(new_Str).add(strs[i]);
        }
        for(String str:map.keySet()){
            if(map.get(str).size()>1){
                ans.addAll(map.get(str));
            }
        }
        //System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        换位词 s=new 换位词();
        String[] strs={"tea","and","ate","eat","dan"};
        s.anagrams(strs);
    }
}
