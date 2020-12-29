package Solution;

public class Solution88 {
    //合并两个有序数组
    public void merge(int A[], int m, int B[], int n) {
        int[] ans=new int[m+n];
        int index_a=0;
        int index_b=0;
        while(index_a<m&&index_b<n){
            if(A[index_a]<B[index_b]){
                ans[index_a+index_b]=A[index_a];
                index_a++;
            }else{
                ans[index_a+index_b]=B[index_b];
                index_b++;
            }
        }
        for(int i=index_a;i<m;i++){
            ans[index_b+i]=A[i];
        }
        for(int i=index_b;i<n;i++){
            ans[index_a+i]=B[i];
        }
        for(int i=0;i<m+n;i++){
            A[i]=ans[i];
        }
    }
}

