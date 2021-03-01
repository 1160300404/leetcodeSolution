/*
有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：

你可以把盒子放在地板上的任何地方。
如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。

 */
public class Solution5664_放置盒子 {
    public int minimumBoxes(int n) {
        int ans=0;
        int height=1;
        while(n>(height*(height+1)/2)){
            n=n-(height*(height+1)/2);
            height++;
        }
        height--;
        ans=height*(height+1)/2;
        int add=1;
        while(n>(add*(add+1)/2)) add++;
        ans+=add;
        return ans;
    }
}
