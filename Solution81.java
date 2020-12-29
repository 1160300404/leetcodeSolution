package Solution;

// 搜索旋转排序数组 II
public class Solution81 {
    public boolean search (int[] A, int target) {
        // write code here
        int length=A.length;
        int start=0;
        int end=length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(A[mid]==target)
                return true;
            if(A[mid]==A[start]){
                start++;
                continue;
            }
            if(A[start]<A[mid]){
                if(A[start]<=target&&A[mid]>=target)
                    end=mid-1;
                else{
                    start=mid+1;
                }
            }else{
                if(A[mid]<=target&&A[end]>=target)
                    start=mid+1;
                else{
                    end=mid-1;
                }
            }
        }
        return false;
    }
}
