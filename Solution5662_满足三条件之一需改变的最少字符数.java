/*
给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。

操作的最终目标是满足下列三个条件 之一 ：

a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
a 和 b 都 由 同一个 字母组成。
返回达成目标所需的 最少 操作数。
 */
public class Solution5662_满足三条件之一需改变的最少字符数 {
    public int minCharacters(String a, String b) {
        int length_a=a.length();
        int length_b=b.length();
        int[] anum=new int[26];
        int[] bnum=new int[26];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<length_a;i++){
            anum[a.charAt(i)-'a']++;
        }
        for(int i=0;i<length_b;i++){
            bnum[b.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            ans=Math.min(ans,length_b+length_a-bnum[i]-anum[i]);
        }
        ans=Math.min(ans,minchange(anum,bnum));
        ans=Math.min(ans,minchange(bnum,anum));
        return ans;
    }
    public int minchange(int[] anum,int[] bnum){
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<26;i++){
            int tmp=0;
            for(int j=i;j<26;j++){
                tmp+=anum[j];
            }
            for(int j=0;j<i;j++){
                tmp+=bnum[j];
            }
            ans = Math.min(ans, tmp);
        }
        return ans;
    }
}
