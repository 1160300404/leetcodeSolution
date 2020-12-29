package Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        if(numRows<=0){
            return ans;
        }
        if(numRows>=1){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(1);
            ans.add(tmp);
        }
        if(numRows>=2){
            List<Integer> tmp=new ArrayList<>();
            tmp.add(1);
            tmp.add(1);
            ans.add(tmp);
            for(int i=2;i<numRows;i++){
                List<Integer> tmp2=new ArrayList<>();
                tmp2.add(1);
                for(int j=1;j<i;j++){
                    tmp2.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
                tmp2.add(1);
                ans.add(tmp2);
            }
        }

        return ans;
    }
}
