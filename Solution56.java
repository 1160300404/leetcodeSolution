package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class Solution56 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size()<2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start- o2.start;
            }
        });
        ArrayList<Interval> ans=new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            Interval start_i=intervals.get(i);
            Interval tmp=new Interval(start_i.start,start_i.end);
            for(int j=i;j<intervals.size();j++){
                Interval end_i=intervals.get(j);
                if(end_i.start>tmp.end) {i=j-1;break;}
                i=j;
                if(tmp.end<=end_i.end) tmp.end=end_i.end;
            }
            ans.add(tmp);
        }
        return  ans;
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        ArrayList<int[]> ans=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] tmp=new int[]{intervals[i][0],intervals[i][1]};
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[j][0]>tmp[1]) {break;}
                i=j;
                if(tmp[1]<=intervals[j][1])  tmp[1]=intervals[j][1];
            }
            ans.add(tmp);
        }
        return ans.toArray(new int[ans.size()][]);
    }
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
            }else if((tmp.start<newInterval.start&&intervals.get(i+1).start>newInterval.start)||i==intervals.size()-1){
                if(newInterval.start>tmp.end){
                    ans.add(tmp); ans.add(newInterval);
                }else{
                    Interval newval=new Interval(tmp.start,Math.max(tmp.end,newInterval.end));
                    ans.add(newval);
                }
                i++;
                break;
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
                    ans.add(ans.size()-1,newval);
                }
            }else{
                ans.add(tmp);
            }
            i++;
        }
        return ans;
    }
}
