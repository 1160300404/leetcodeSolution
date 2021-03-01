/*
给你两个长度相同的字符串，s 和 t。

将 s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），
也就是两个字符的 ASCII 码值的差的绝对值。

用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，
这也意味着字符串的转化可能是不完全的。

如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。

如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

 */
public class Solution_1208尽可能使字符串相等 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length=s.length();
        int[] diff=new int[length];
        for(int i=0;i<length;i++){
            diff[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int ans=0,left=0,right=0,sum=0;
        while(right<length){
            sum=sum+diff[right];
            if(sum<=maxCost){
                ans=right-left+1;
            }else{
                sum=sum-diff[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}
