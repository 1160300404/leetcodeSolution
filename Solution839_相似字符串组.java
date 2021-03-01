import java.util.Arrays;

/*
如果交换字符串X 中的两个不同位置的字母，使得它和字符串Y 相等，那么称 X 和 Y 两个字符串相似。
如果这两个字符串本身是相等的，那它们也是相似的。

例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)；"rats" 和 "arts" 也是相似的，
但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。

总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 
和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。

给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。
请问 strs 中有多少个相似字符串组？


 */
public class Solution839_相似字符串组 {
    public int numSimilarGroups(String[] strs) {
        int length=strs[0].length();
        int[] f=new int[length];
        int[] rank=new int[length];
        int count=length;
        Arrays.fill(rank,1);
        for(int i=0;i<length;i++) f[i]=i;
        int[][] dis=new int[length][length];
        for(int i=0;i<length;i++){
            for(int j=i+1 ;j<length;j++){
                if(distance(strs[i],strs[j],length)){
                    if(merge(rank,f,i,j)){
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public boolean distance(String s,String j,int length){
        int count=0;
        for(int i=0;i<length;i++){
            if(s.charAt(i)!=j.charAt(i)){
                count++;
                if (count>2) {
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int[] f,int x){
        return x==f[x]?x:(f[x]=find(f,f[x]));
    }
    public boolean merge(int[] rank,int[] f,int x,int y){
        int fx=find(f,x);
        int fy=find(f,y);
        if(fx==fy) return false;
        if(rank[fx]<rank[fy]){
            int tmp=fx;
            fx=fy;
            fy=tmp;
        }
        f[fy]=fx;
        rank[fx]+=rank[fy];
        return true;
    }
}