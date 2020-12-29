package Solution;

import java.util.ArrayList;
import java.util.List;

//将数组拆分成斐波那契序列
public class Solution842 {
    long check=Integer.MAX_VALUE;
    public List<Integer> splitIntoFibonacci(String S){
        List<Integer> ans=new ArrayList<>();
        if(S.length()<3) return ans;
        ans= dfs(S,-1,-1,0);
        return ans;
    }
    public List<Integer> dfs(String S,int last,int lastlast,int begin){
        List<Integer> ans=new ArrayList<>();
        int tmp_int=lastlast;
        for(int i=begin;i<S.length();i++) {
            long now = Long.parseLong(S.substring(begin, i + 1));
            if (now > check) break;
            int real = (int) now;
            if (last != -1 && lastlast != -1 && last + lastlast != real) {
                continue;
            }
            ans.add(real);
            if (last != -1 && lastlast != -1 && last + lastlast == real && i==S.length()-1){
                return ans;
            }
            lastlast = last;
            last = real;
            List<Integer> tmp = dfs(S, last, lastlast, i+1);
            if (tmp.size() != 0) {
                ans.addAll(tmp);
                return ans;
            }
            ans.remove(ans.size() - 1);
            last=lastlast;
            lastlast=tmp_int;
            if (S.charAt(begin) == '0') break;
        }
        return  ans;
    }

    public static void main(String[] args) {
        Solution842 s=new Solution842();
        s.splitIntoFibonacci("123456579");
        //s.splitIntoFibonacci("11235813");
        //s.splitIntoFibonacci("1101111");
    }
}
