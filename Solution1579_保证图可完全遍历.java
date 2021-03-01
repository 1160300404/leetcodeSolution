import java.util.Arrays;
import java.util.Comparator;

/*
Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3 种类型的边：

类型 1：只能由 Alice 遍历。
类型 2：只能由 Bob 遍历。
类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi]表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。

返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 

 */
public class Solution1579_保证图可完全遍历 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int index=0;
        int ans=0;
        DisjointSetUnion_4 dsu_a=new DisjointSetUnion_4(n);
        DisjointSetUnion_4 dsu_b=new DisjointSetUnion_4(n);
        for(;index<edges.length;index++){
            if(edges[index][0]!=3) break;
            int from = edges[index][1]-1;
            int to = edges[index][2]-1;
            if(!dsu_a.union(from,to)){
                ans++;continue;
            }
            dsu_b.union(from,to);
        }
        for(;index<edges.length;index++){
            if(edges[index][0]!=2) break;
            int from = edges[index][1]-1;
            int to = edges[index][2]-1;
            if(!dsu_b.union(from,to)){
                ans++;continue;
            }
        }
        for(;index<edges.length;index++){
            if(edges[index][0]!=1) break;
            int from = edges[index][1]-1;
            int to = edges[index][2]-1;
            if(!dsu_a.union(from,to)){
                ans++;continue;
            }
        }
        if(dsu_a.count>1||dsu_b.count>1) return -1;
        return ans;
    }
}
class DisjointSetUnion_4{
    private int[] fa;
    private int n;
    public int count;
    private int[] rank;
    public DisjointSetUnion_4(int n){
        this.fa=new int[n];
        for(int i=0;i<n;i++) fa[i]=i;
        this.rank=new int[n];
        Arrays.fill(rank,1);
        this.n=n;
        this.count=n;
    }
    public int find(int x){
        return x==fa[x]?x:(fa[x]=find(fa[x]));
    }
    public boolean union(int x,int y){
        int fa_x=find(x);
        int fa_y=find(y);
        if(fa_x==fa_y) return false;
        if(rank[fa_x]<rank[fa_y]){
            int tmp=fa_x;
            fa_x=fa_y;
            fa_y=tmp;
        }
        rank[fa_x]+=rank[fa_y];
        fa[fa_y]=fa_x;
        this.count--;
        return true;
    }
}
