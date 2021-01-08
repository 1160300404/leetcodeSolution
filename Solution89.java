package Solution;

import java.util.ArrayList;
// 格雷编码
public class Solution89 {
    public ArrayList<Integer> grayCode (int n) {
        // write code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(n<0)
            return ans;
        ans.add(0);
        for(int i=1;i<=n;i++){
            int length=ans.size()-1;
            for(int j=length;j>=0;j--){
                int add=(int)Math.pow(2,(i-1));
                ans.add(ans.get(j)+add);
            }
        }
        return ans;
    }
}
