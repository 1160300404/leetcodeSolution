package Solution;

import java.util.ArrayList;

public class Solution93 {
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        return dfs(s,0);
    }
    public ArrayList<String> dfs(String s,int depth){
        ArrayList<String> ans=new ArrayList<String>();
        if(s.length()>3*(4-depth)||s.length()<1)
            return ans;
        for(int i=1;i<=3;i++){
            String sub=s.substring(0,i);
            if(Integer.parseInt(sub)<=255){
                if(i==s.length()){
                    if(depth==3)
                        ans.add(sub);
                    break;
                }
                ArrayList<String> tmp=dfs(s.substring(i),depth+1);
                for(int j=0;j<tmp.size();j++){
                    ans.add(sub+"."+tmp.get(j));
                }
                if(s.charAt(0)=='0'){
                    break;
                }
            }
        }
        return ans;
    }
}
