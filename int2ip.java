package Solution;


import java.util.*;


public class int2ip {
    /**
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
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
            if(i==s.length()){
                System.out.printf("%s %d \n",sub,Integer.parseInt(sub));
                if(depth==3&&Integer.parseInt(sub)<=255){
                    ans.add(sub);
                }
                break;
            }
            if(Integer.parseInt(sub)<=255){
                ArrayList<String> tmp=dfs(s.substring(i),depth+1);
                for(int j=0;j<tmp.size();j++){
                    ans.add(sub+"."+tmp.get(j));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="0000";
        int2ip test=new int2ip();
        test.restoreIpAddresses(s);
    }
}