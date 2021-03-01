/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution_剑指Offer39数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        int ans=0,vote=0;
        for(int num:nums){
            if(vote==0) ans=num;
            vote+=num==ans?1:-1;
        }
        return ans;
    }
}
