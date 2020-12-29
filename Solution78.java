package Solution;

import java.util.ArrayList;
import java.util.List;

// 子集
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        if(nums.length<1)
            return ans;
        for(int i=0;i<nums.length;i++){
            int length=ans.size();
            for(int j=0;j<length;j++){
                List<Integer> tmp=new ArrayList<>();
                tmp.addAll(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}
