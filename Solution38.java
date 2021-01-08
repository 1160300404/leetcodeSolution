package leetcode;

public class Solution38 {
    public String countAndSay (int n) {
        // write code here
        if(n==0) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        if(n==1) return sb.toString();
        for(int i=2;i<=n;i++){
            String tmp=sb.toString();
            sb= new StringBuilder();
            int cnt=1;
            for(int j=1;j<tmp.length();j++){
                if(tmp.charAt(j)==tmp.charAt(j-1)){
                    cnt++;
                }else{
                    String tmp_str=cnt+""+tmp.charAt(j-1);
                    sb.append(tmp_str);
                    cnt=1;
                }
            }
            String tmp_str=cnt+""+tmp.charAt(tmp.length()-1);
            sb.append(tmp_str);
            System.out.println(sb.toString());
        }
        return sb.toString();
    }
}
