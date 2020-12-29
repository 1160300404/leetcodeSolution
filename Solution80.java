package Solution;

// 删除排序数组中的重复项 II
public class Solution80 {
    public int removeDuplicates(int[] A) {
        int length=A.length;
        if(length<2)
            return length;
        for(int i=0;i<length;i++){
            int left=-1;
            int right=-1;
            while(i+1<length&&A[i]==A[i+1]){
                if(left==-1&&right==-1){
                    left=i;
                    right=i+1;
                }else{
                    right=i+1;
                }
                i++;
            }
            int cnt=right-left+1;
            if(cnt>2){
                for(int j=right+1;j<length;j++){
                    A[j-cnt+2]=A[j];
                }
                length=length-(cnt-2);
                i=i-(cnt-2);
            }

        }
        return length;
    }
}
