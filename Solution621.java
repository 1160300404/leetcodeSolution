package Solution;

import javafx.util.Pair;

import java.util.*;
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        int length=tasks.length;
        int ans=0;
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-1;
            }
        });
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            int tmp=map.getOrDefault(tasks[i],0)+1;
            map.put(tasks[i],tmp);
        }
        for(Character c: map.keySet()){
            heap.add(map.get(c));
        }
        while(length>0){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<=n;i++){
                list.add(heap.poll());
            }

            for(int i=0;i<=n;i++) {
                ans++;
                if(list.get(i)!=null){
                    int tmp=list.get(i);
                    if(tmp>1){
                        heap.add(tmp-1);
                    }
                    length--;
                    if(length<=0) return  ans;
                }
            }
        }
        return  ans;
    }

    public static void main(String[] args) {

    }
}
