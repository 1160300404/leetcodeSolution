package Solution;

//91. 解码方法
public class Solution91 {
    public int numDecodings (String s) {
        // write code here
        if(s.length()==0||s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;
        int length=s.length();
        int[] dp=new int[length+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=length;i++){
            String sub=s.substring(i-2,i);
            int sub_int=Integer.parseInt(sub);
            if(sub_int<=26&&sub_int>=10){
                if(s.charAt(i-1)!='0')
                    dp[i]=dp[i-1]+dp[i-2];
                else
                    dp[i]=dp[i-2];
            }else if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
        }
        return dp[length];
    }
}
