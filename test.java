package Solution;


import java.util.*;

public class test {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int height=matrix.length;
        int length=matrix[0].length;
        int[] ht=new int[length];
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height;i++){
            stack.clear();
            int[] left=new int[length];
            int[] right=new int[length];
            Arrays.fill(right,length);
            for(int j=0;j<length;j++){
                if(matrix[i][j]=='1')
                    ht[j]+=1;
                else
                    ht[j]=0;
            }
            for(int j=0;j<length;j++){
                while(!stack.isEmpty()&&ht[j]<=ht[stack.peek()]){
                    System.out.printf("%d %d %d %d %d\n",i,j,stack.peek(),ht[j],ht[stack.peek()]);
                    right[stack.peek()]=j;
                    stack.pop();
                }
                left[j]=stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            for(int j=0;j<length;j++){
                max=Math.max(max,(right[j]-left[j]-1)*ht[j]);
                //System.out.printf("%d %d %d %d\n",right[j],left[j],ht[j],max);
            }
        }
        System.out.println(max);
        return max;
    }
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack=new Stack<>();
        Queue<Character> queue=new LinkedList<>();
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char[] array=s.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]=='('||array[i]=='['||array[i]=='{'){
                stack.push(array[i]);
            }else if(!stack.isEmpty()&&array[i]==map.get(stack.peek())){
                stack.pop();
            }else{
                System.out.println(array[i]);
                return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public int[] searchRange (int[] A, int target) {
        // write code here
        int end=A.length-1;
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        dfs(A,0,end,target,ans);
        return ans;
    }
    public void dfs(int[] A,int start,int end,int target,int[] ans){
        if(start>end)
            return;
        int mid=(start+end)/2;

        if(A[mid]==target){
            System.out.println(mid);
            if(ans[0]==-1){
                Arrays.fill(ans,mid);

            }else if(ans[0]>mid)
                ans[0]=mid;
            else if(ans[1]<mid)
                ans[1]=mid;
            dfs(A,start,mid-1,target,ans);
            dfs(A,mid+1,end,target,ans);
        }
        else if(A[mid]>target)
            dfs(A,start,mid-1,target,ans);
        else
            dfs(A,mid+1,end,target,ans);
    }
    public static void main(String[] args) {
//        test s=new test();
//
//        System.out.println(s.searchRange(new int[]{0,0,0,0,0,0,1,1,2,2,3,3,4,4,4},0));
        System.out.println('0'*10);
    }

}
