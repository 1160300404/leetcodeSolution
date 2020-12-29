package Solution;

public class Solution922 {
    public int[] sortArrayByParityII(int[] A) {
        int index1=0;
        int index2=1;
        int length=A.length;
        while(index2<=length-1&&index1<=length-2){
            while(index1<=length-2&&A[index1]%2==0){
                index1+=2;
            }
            while(index2<=length-1&&A[index2]%2==1){
                index2+=2;
            }
            if(index1==length){
                break;
            }
            int tmp = A[index1];
            A[index1]=A[index2];
            A[index2]=tmp;
        }
        return A;
    }
}
