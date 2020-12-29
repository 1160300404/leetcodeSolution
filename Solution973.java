package Solution;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans=new int[K][2];
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int length=points.length;
        for(int i=0;i<length;i++){
            int tmp=(int)Math.pow(points[i][0],2.0)+(int)Math.pow(points[i][1],2.0);
            if(map.containsKey(i)){
                map.get(i).add(i);
            }else{
                ArrayList<Integer> tmplist=new ArrayList<>();
                tmplist.add(i);
                map.put(i,tmplist);
            }
            if(!queue.contains(tmp))
                queue.add(tmp);
        }
        int index=0;
        while(K>0){
            int tmpindex=queue.poll();
            ArrayList<Integer> tmplist=map.get(tmpindex);
            for(int i=0;i<tmplist.size();i++){
                ans[index]=points[tmplist.get(i)];
                K--;
                if(K==0){
                    break;
                }
                index++;
            }
        }
        return  ans;
    }
}
