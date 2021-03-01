import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Solution_剑指Offer38字符串的排列 {
    int index=0;
    HashSet<String> list=new HashSet<>();
    public String[] permutation(String s) {
        if(s.length()==0) return new String[0];
        Permutation(s.toCharArray(),0);
        return list.toArray(new String[0]);
    }
    public void Permutation(char[] s ,int index){
        if(index==s.length){
            list.add(new String(s));
            return;
        }
        for(int i=index;i<s.length;i++){
            char tmp=s[index];
            s[index]=s[i];
            s[i]=tmp;
            Permutation(s,index+1);
            s[i]=s[index];
            s[index]=tmp;
        }
    }
}
