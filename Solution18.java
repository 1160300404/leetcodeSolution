package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int first=0;first<nums.length;first++){
            if(first>0&&nums[first]==nums[first-1])
                continue;
            for(int second=first+1;second<nums.length;second++){
                if(second>first+1&&nums[second]==nums[second-1])
                    continue;
                int value=target-nums[first]-nums[second];
                int fourth=nums.length-1;
                for(int third=second+1;third<nums.length;third++){
                    if(third>second+1&&nums[third]==nums[third-1])
                        continue;
                    while (fourth>third&&nums[third]+nums[fourth]>value){
                        fourth--;
                    }
                    if(fourth==third)
                        break;
                    if(nums[third]+nums[fourth]==value){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution18 s=new Solution18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans=s.fourSum(nums,0);
        for(int i=0;i<ans.size();i++){
            System.out.printf("%d %d %d %d",ans.get(i).get(0),ans.get(i).get(1),ans.get(i).get(2),ans.get(i).get(3));
            System.out.println();
        }
        System.out.println(ans.size());
    }
}
