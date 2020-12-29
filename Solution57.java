package Solution;

import java.util.ArrayList;

// 插入区间
public class Solution57 {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans=new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0){
            ans.add(newInterval);
            return ans;
        }
        int i=0;
        boolean merge=true;
        while(i<intervals.size()){
            Interval tmp=intervals.get(i);
            if(tmp.start==newInterval.start){
                Interval newval=new Interval(tmp.start,Math.max(tmp.end,newInterval.end));
                ans.add(newval); i++;
                break;
            }else if(tmp.start>newInterval.start){
                if(tmp.start<=newInterval.end){
                    Interval newval=new Interval(newInterval.start,Math.max(tmp.end,newInterval.end));
                    ans.add(newval);
                }else{
                    ans.add(newInterval);ans.add(tmp);
                }
                i++;
                break;
            }else if(tmp.start<newInterval.start){
                if(newInterval.start<=tmp.end){
                    Interval newval=new Interval(tmp.start,Math.max(tmp.end,newInterval.end));
                    ans.add(newval);
                    i++;
                    break;
                }
                if(i==intervals.size()-1){
                    ans.add(tmp);ans.add(newInterval);
                    i++;break;
                }
            }
            ans.add(tmp);
            i++;
        }
        while(i<intervals.size()){
            Interval tmp=intervals.get(i);
            if(merge){
                Interval tmp2=ans.get(ans.size()-1);
                if(tmp.start>tmp2.end){
                    merge=false; ans.add(tmp);
                }else{
                    Interval newval=new Interval(tmp2.start,Math.max(tmp.end,tmp2.end));
                    ans.remove(tmp2);
                    ans.add(newval);
                }
            }else{
                ans.add(tmp);
            }
            i++;
        }
        return ans;
    }
}
