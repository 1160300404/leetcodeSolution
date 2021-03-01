package zhousai229;

public class 移动所有球到每个盒子所需的最小操作数 {
    public int[] minOperations(String boxes) {
        int[] ans=new int[boxes.length()];
        int n=boxes.length();
        int num=0;
        if(boxes.charAt(0)=='1') num=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]+num;
            if(boxes.charAt(i)=='1'){
                num++;
                for(int j=0;j<i;j++){
                    ans[j]+=(i-j);
                }
            }
        }
        return ans;
    }
}
