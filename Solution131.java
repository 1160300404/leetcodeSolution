package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution131 {
    public List<List<String>> partition(String s) {
        return bfs(s);
    }
    public List<List<String>> bfs(String s){
        List<List<String>> ans =new ArrayList<>();
        if(s.length()<1){
            ans.add(new ArrayList<String>());
            return ans;
        }
        for(int i=s.length()-1;i>=0;i--){
            String sub=s.substring(i,s.length());
            if(is_huiwen(sub)){
                if(i==0){
                    List<String> list=new ArrayList<>();
                    list.add(sub);
                    ans.add(list);
                    continue;
                }
                List<List<String>> tmp=bfs(s.substring(0,i));
                for(int j=0;j<tmp.size();j++){
                    tmp.get(j).add(sub);
                }
                ans.addAll(tmp);
            }
        }
        return ans;
    }
    public boolean is_huiwen(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
