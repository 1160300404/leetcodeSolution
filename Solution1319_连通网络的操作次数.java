import java.util.Arrays;

public class Solution1319_连通网络的操作次数 {
    public int makeConnected(int n, int[][] connections) {
        int counts=connections.length;
        if(n-1>counts) return -1;
        DisjointSetUnion_3 dsu=new DisjointSetUnion_3(n);
        for(int i=0;i<counts;i++){
            if(dsu.union(connections[i][0],connections[i][1]))
                dsu.setcount--;
        }
        return dsu.setcount-1;
    }
}
class DisjointSetUnion_3{
    int[] fa;
    int[] rank;
    int n;
    int setcount;
    public DisjointSetUnion_3(int n){
        this.n=n;
        this.setcount=n;
        fa=new int[n];
        rank=new int[n];
        Arrays.fill(rank,1);
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }
    public int find(int x){
        return fa[x]==x?x:(fa[x]=find(fa[x]));
    }
    public boolean union(int x,int y){
        int fa_x=find(x);
        int fa_y=find(y);
        if(fa_x==fa_y)
            return false;
        // System.out.printf("%d %d %d %d\n",x,y,fa_x,fa_y);
        if(rank[fa_x]<rank[fa_y]){
            int tmp=fa_x;
            fa_x=fa_y;
            fa_y=tmp;
        }
        fa[fa_y]=fa_x;
        rank[fa_x]+=rank[fa_y];
        return true;
    }
}
