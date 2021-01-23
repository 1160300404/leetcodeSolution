import java.util.LinkedList;
import java.util.List;

public class Solution_989数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length=A.length;
        LinkedList<Integer> ans=new LinkedList<>();
        int add=0;
        while(length>0&&K>0){
            int he=A[--length]+K%10+add;
            add=he/10;
            he=he%10;
            ans.addFirst(he);
            K=K/10;
        }
        while(length>0){
            int he=A[--length]+add;
            add=he/10;
            he=he%10;
            ans.addFirst(he);
        }
        while(K>0){
            int he=K%10+add;
            add=he/10;
            he=he%10;
            ans.addFirst(he);
            K=K/10;
        }
        return ans;
    }
}
