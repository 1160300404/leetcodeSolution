/*
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

 */
public class Solution_剑指Offer19正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        return dfs(s,p,0,0);
    }
    public boolean dfs(String s,String p,int s_index,int p_index){
        if(s_index==s.length()&&p_index==p.length()){
            return true;
        }
        if(s_index==s.length()&&p_index<p.length()) {
            if(p_index<p.length()-1&&p.charAt(p_index+1)=='*')
                return dfs(s,p,s_index,p_index+2);
            else return false;
        }
        if(s_index<s.length()&&p_index==p.length()) return false;
        if(p_index<p.length()-1&&p.charAt(p_index+1)=='*'){
            boolean ans=false;
            if(s.charAt(s_index)==p.charAt(p_index)||p.charAt(p_index)=='.'){
                ans=dfs(s,p,s_index+1,p_index+2)|| dfs(s,p,s_index+1,p_index);
            }
            return ans||dfs(s,p,s_index,p_index+2) ;
        }
        else if(s.charAt(s_index)==p.charAt(p_index)||p.charAt(p_index)=='.'){
            return dfs(s,p,s_index+1,p_index+1);
        }
        else{
            return false;
        }
    }
    public boolean isMatch_2(String s, String p) {
        int s_length=s.length(),p_length=p.length();
        boolean[][] dp=new boolean[s_length+1][p_length+1];
        dp[0][0]=true;
        for(int i=0;i<=s_length;i++){
            for(int j=1;j<=p_length;j++){
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[s_length][p_length];
    }
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
