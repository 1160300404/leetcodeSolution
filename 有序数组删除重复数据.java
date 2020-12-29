package Solution;

public class 有序数组删除重复数据 {
    public int removeDuplicates(int[] A) {
        int ans=0;
        for(int i=0;i<A.length;i++){
            if(i!=0&&A[i-1]==A[i])
                continue;
            A[ans]=A[i];
            ans++;
        }
        return ans;
    }
}
