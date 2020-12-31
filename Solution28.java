package Solution;
//28. 实现 strStr()
/*
实现  strStr()  函数。

给定一个  haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回   -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int length_s=haystack.length();
        int length_d=needle.length();
        if(haystack.equals(needle))
            return 0;
        for(int i=0;i<=length_s-length_d;i++){
            if(haystack.substring(i,i+length_d).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
