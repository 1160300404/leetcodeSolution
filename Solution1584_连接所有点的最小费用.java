import javafx.util.Pair;
import sun.misc.Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。

连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：|xi - xj| + |yi - yj|，其中|val|表示val的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，才认为所有点都已连接。

 */
public class Solution1584_连接所有点的最小费用 {
    public int minCostConnectPoints(int[][] points) {
        int length=points.length;
        int ans=0;
        int[][] dis=new int[length][length];
        boolean[] visited=new boolean[length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                dis[i][j]=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        int[] lowest = new int[length];
        Arrays.fill(lowest,Integer.MAX_VALUE);
        int start=0,count=1;
        visited[0]=true;
        while(count<length){
            int next=0,min=Integer.MAX_VALUE;
            for(int i=0;i<length;i++){
                if(i==start||visited[i]) continue;
                lowest[i]=Math.min(lowest[i],dis[i][start]);
                if(!visited[i]&&lowest[i]<min){
                    next=i;min=lowest[i];
                }
            }
            ans+=min;
            count++;
            start= next;
            visited[next]=true;
        }
        return ans;
    }
}

