package Solution;

import java.util.ArrayList;

//93. 复原IP地址
/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 */
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
