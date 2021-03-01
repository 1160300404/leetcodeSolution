/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution_剑指Offer05_替换空格 {
    public String replaceSpace(String s) {
        StringBuilder stb=new StringBuilder();
        for(int i=0;i< s.length();i++){
            int start=i;
            while (i<s.length()&&s.charAt(i)!=' '){
                i++;
            }
            stb.append(s.substring(start,i));
            if(i<s.length())
                stb.append("%20");
        }
        return stb.toString();
    }
}
