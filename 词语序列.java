package Solution;


import java.util.ArrayList;
import java.util.Arrays;

public class 词语序列 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        int shortest=Integer.MAX_VALUE;
        if(start.equals(end)){
            ArrayList<String> tmp=new ArrayList<String>();
            tmp.add(start);
            ans.add(tmp);
            return ans;
        }
        int index=dict.indexOf(start);
        if(index!=-1)
            dict.set(index,"");
        for(int i=0;i<dict.size();i++){
            String tmp_str=dict.get(i);
            if(is_distance(start,tmp_str)){
                ArrayList<ArrayList<String>> tmp_ans= findLadders(tmp_str,end,dict);
                for(int j=0;j<tmp_ans.size();j++){
                    if(shortest>=tmp_ans.get(j).size()){
                        shortest=tmp_ans.get(j).size();
                        ArrayList<String> tmp=new ArrayList<String>();
                        tmp.add(start);
                        tmp.addAll(tmp_ans.get(j));
                        ans.add(tmp);
                    }
                }
            }
        }
        dict.set(index,start);
        ArrayList<ArrayList<String>> tmp_ans=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size()==shortest+1){
                tmp_ans.add(ans.get(i));
            }
        }
        return tmp_ans;
    }
    public boolean is_distance(String s,String tmp){
        if(s.length()!=tmp.length())
            return false;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=tmp.charAt(i)){
                ans++;
            }
        }
        return ans==1?true:false;
    }

    public static void main(String[] args) {
        ArrayList<String> str=new ArrayList<>();
        str.addAll(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        String start="red",end="tax";
        词语序列 a=new 词语序列();
        ArrayList<ArrayList<String>> ans=a.findLadders(start,end,str);
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                System.out.printf("%s ",ans.get(i).get(j));
            }
            System.out.println();
        }

    }
}
