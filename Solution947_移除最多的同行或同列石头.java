public class Solution947_移除最多的同行或同列石头 {
    /*
    n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。

     */
    public int removeStones(int[][] stones) {
        int length=stones.length;
        boolean[] visited=new boolean[length];
        int ans=0;
        for(int i=0;i<length;i++){
            if(!visited[i]){
                ans++;
                dfs(stones,i,length,visited);
            }
        }
        return length-ans;
    }
    public void dfs(int[][] stones,int index,int length,boolean[] visited){
        visited[index]=true;
        for(int i=index+1;i<length;i++){
            if(!visited[i]&&(stones[i][0]==stones[index][0]||stones[i][1]==stones[index][1])){
                dfs(stones,i,length,visited);
            }
        }
    }
}
