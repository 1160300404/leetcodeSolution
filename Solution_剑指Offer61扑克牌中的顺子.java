import java.util.HashSet;
import java.util.Set;

public class Solution_剑指Offer61扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int min=nums[0],max=nums[0];
        Set<Integer> set=new HashSet<>();
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(set.contains(num)) return false; // 若有重复，提前返回 false
            set.add(num); // 添加此牌至 Set
        }
        String a="asdasd";
        a.trim();
        return max - min < 5;
    }
}
