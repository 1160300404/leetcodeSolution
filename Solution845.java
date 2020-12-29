package Solution;

public class Solution845 {
    public int longestMountain(int[] A) {
        int length=A.length;
        if(length<=0){
            return 0;
        }
        int result=0;
        int begin=-1;
        int end=0;
        boolean rise=true;
        for(int i=1;i<length;i++){
            if(begin==-1){
                if(A[i]>A[end]){
                    begin=end;
                    end=i;
                    continue;
                }else{
                    end=i;
                    continue;
                }
            }
            if(rise){
                if(A[i]==A[end]){
                    begin=-1;
                    end=i;
                }else if(A[i]<A[end]){
                    end=i;
                    result=Math.max(result,(end-begin+1));
                    rise=false;
                }else{
                    end=i;
                }
                continue;
            }else{
                if(A[i]>A[end]){
                    result=Math.max(result,(end-begin+1));
                    rise=true;
                    begin=end;
                    end=i;
                }else if(A[i]==A[end]){
                    result=Math.max(result,(end-begin+1));
                    rise=true;
                    begin=-1;
                    end=i;
                }else{
                    end=i;
                }
            }
        }
        if(!rise){
            result=Math.max(result,(length-begin));
        }
        return  result;
    }
}
