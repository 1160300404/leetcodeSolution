import java.util.Arrays;
/*
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v]，满足u < v，表示连接顶点u和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边[u, v] 应满足相同的格式u < v。
 */
public class Solution684_冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSetUnion dis=new DisjointSetUnion(edges.length+1);
        int[] ans=new int[2];
        for(int i=0;i<edges.length;i++){
            if(dis.find(edges[i][0])==dis.find(edges[i][1])){
                ans[0]=edges[i][0];ans[1]=edges[i][1];
                continue;
            }
            dis.unionSet(edges[i][0],edges[i][1]);
        }
        return ans;
    }

}
class DisjointSetUnion {
    int[] f;
    int[] rank;
    int n;
    public  DisjointSetUnion (int n){
        this.n=n;
        rank=new int[n];
        Arrays.fill(rank,1);
        f=new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }
    public int find(int x){
        return f[x]==x?x:(f[x]=find(f[x]));
    }
    public void unionSet(int x,int y){
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
    }
}