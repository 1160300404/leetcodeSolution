import java.util.Arrays;

public class Solution778_水位上升的泳池中游泳 {
    public int swimInWater(int[][] grid) {
        int length=grid.length;
        DisjointSetUnion_5 setu=new DisjointSetUnion_5(length*length);
        int[][] height=new int[length*length][2];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                height[grid[i][j]][0]=i;
                height[grid[i][j]][1]=j;
            }
        }
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int limit=0;limit<length*length;limit++){
            for(int[] step:move){
                int ni=height[limit][0]+step[0];
                int nj=height[limit][1]+step[1];
                if(ni>=0&&ni<length&&nj>=0&&nj<length&&grid[ni][nj]<=limit){
                    setu.merge(height[limit][0]*length+height[limit][1],ni*length+nj);
                }
                if(setu.find(0)==setu.find(length*length-1)){
                    return limit;
                }
            }
        }
        return -1;
    }

}
class DisjointSetUnion_5{
    int n;
    int[] f;
    int[] rank;
    public DisjointSetUnion_5(int n){
        this.n=n;
        this.f=new int[n];
        for(int i=0;i<n;i++){
            f[i]=i;
        }
        this.rank=new int[n];
        try {
            Arrays.fill(rank,1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int find(int x){
        return x==f[x]?x:(f[x]=find(find(f[x])));
    }
    public boolean merge(int x,int y){
        int fx=find(x);
        int fy=find(y);
        if(fx==fy) return false;
        if(rank[fx]<rank[fy]){
            int tmp=fx;
            fx=fy;
            fy=tmp;
        }
        f[fy]=fx;
        rank[fx]+=rank[fy];
        return true;
    }
}
