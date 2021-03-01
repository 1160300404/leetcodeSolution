import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 */
public class Solution792_匹配子序列的单词数 {
    public int numMatchingSubseq(String S, String[] words) {
        int ans=0;
        HashMap<Character, List<Integer>> map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)('a'+i),new ArrayList<>());
        }
        for(int i=0;i<S.length();i++){
            map.get(S.charAt(i)).add(i);
        }
        for(int i=0;i<words.length;i++){
            if(issub(S,words[i],map)){
                ans++;
            }
        }
        return ans;
    }
    public boolean issub(String S, String sub, Map<Character,List<Integer>> map){
        int index2=0;
        int last=-1;
        while(index2<sub.length()){
            char sub_char=sub.charAt(index2);
            List<Integer> char_list=map.get(sub_char);
            if(char_list.size()==0) return false;
            int now_index=findindex(char_list,last);
            if(now_index<0) return false;
            last=now_index;
            index2++;
        }
        return true;
    }
    public int findindex(List<Integer> list,int last){
        int start=0,end=list.size()-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(list.get(mid)<=last){
                start=mid+1;
            }else if(mid==0||list.get(mid-1)<=last){
                return list.get(mid);
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
