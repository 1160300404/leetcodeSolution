package Solution;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int m=nums1.length;
        int n=nums2.length;
        if(m==0&&n==0){
            return 0;
        }
        int mid1=(m+n-1)/2+1,mid2=(m+n)/2+1;
        int index1=0,index2=0,change=0;
        for(int i=0;i<(m+n)/2+1;i++){
            float nums1tmp=index1>=m?Float.POSITIVE_INFINITY:nums1[index1];
            float nums2tmp=index2>=n?Float.POSITIVE_INFINITY:nums2[index2];
            if(nums1tmp<=nums2tmp){
                index1++;
                change=1;
            }else{
                index2++;
                change=2;
            }
            int tmp=index1+index2;
            if(tmp==(mid1)||tmp==(mid2)){
                if(change==1){
                    ans+=nums1[index1-1];
                }else{
                    ans+=nums2[index2-1];
                }
            }

        }
        if(mid1!=mid2){
            return ans/2;
        }
        return ans;
    }
}
