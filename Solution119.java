package Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        int[] anss=new int[rowIndex+1];
        List<Integer> ans=new ArrayList<>();
        if(rowIndex<0){
            return ans;
        }
        if(rowIndex>=0){
            anss[0]=1;
        }
        if(rowIndex>=1){
            anss[1]=1;
            for(int i=2;i<rowIndex+1;i++){
                anss[i]=1;
                for(int j=i-1;j>0;j--){
                    anss[j]=anss[j]+anss[j-1];
                }
            }
        }
        for(int i=0;i<rowIndex+1;i++){
            ans.add(anss[i]);
        }
        return ans;
    }
}
