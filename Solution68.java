package Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length=words.length;
        int start=0,end=0,rowlength=words[0].length();
        List<String> ans=new ArrayList<>();
        for(int i=0;i<length;i++){
            if(end<length-1&&rowlength<=maxWidth){
                end++;
                rowlength+=(end-start)+words[end].length();
                continue;
            }
            rowlength=rowlength-1-words[end].length();
            end--;
            int extra=(maxWidth-rowlength)%(end-start);
            StringBuilder tmp=new StringBuilder(words[start]);
            for(int j=0;j<extra;j++)
                tmp.append(" ");
            for(int j=start+1;j<=end;j++){
                tmp.append(" "+words[end]);
            }
            ans.add(tmp.toString());
            end++;
            start=end;
            rowlength=words[start].length();
        }
        return  ans;
    }
    public List<String> fullJustify2(String[] words, int maxWidth) {
        int length=words.length;
        int start=0,end=0,rowlength=words[0].length();
        List<String> ans=new ArrayList<>();
        while (end<length){
            if(rowlength<=maxWidth){
                end++;
                if(end<length) {
                    rowlength += (end - start) + words[end].length();
                    continue;
                }
            }
            if(end<length)
                rowlength=rowlength-1-words[end].length();
            end--;
            int extra=(maxWidth-rowlength)%(end-start);
            StringBuilder tmp=new StringBuilder(words[start]);
            for(int j=0;j<extra;j++)
                tmp.append(" ");
            for(int j=start+1;j<=end;j++){
                tmp.append(" "+words[end]);
            }
            ans.add(tmp.toString());
            end++;
            start=end;
            if(end<length)
                rowlength=words[start].length();
        }
        System.out.println();
        return  ans;
    }
}
