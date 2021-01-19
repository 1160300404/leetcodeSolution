import java.util.ArrayList;
import java.util.List;

public class Solution1018_可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int last=0;
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            last=(last*2+A[i])%5;
            if(last==0)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}
