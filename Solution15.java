package Solution;


import java.lang.reflect.Array;
import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        HashSet<List<Integer>> set=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int value=-nums[i];
            int k=nums.length-1;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1])
                    continue;
                while(k>j&&nums[k]+nums[j]>value){
                    k--;
                }
                if(k==j)
                    break;
                if(nums[k]+nums[j]==value){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution15 s=new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans=s.threeSum(nums);
        for(int i=0;i<ans.size();i++){
            System.out.printf("%d %d %d",ans.get(i).get(0),ans.get(i).get(1),ans.get(i).get(2));
            System.out.println();
        }
        System.out.println(ans.size());
    }
}
