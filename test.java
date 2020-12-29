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
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        int left=n,right=n;
        return dfs(left,right);
    }
    public ArrayList<String> dfs(int left,int right){
        ArrayList<String> ans=new ArrayList<String>();
        if(left==0){
            String str="";
            for(int i=0;i<right;i++)
                str+=")";
            ans.add(str+"");
            return ans;
        }
        ArrayList<String> tmp=dfs(left-1,right);
        for(int i=0;i<tmp.size();i++){
            ans.add("("+tmp.get(i));
        }
        if(right-left>0){
            tmp=dfs(left,right-1);
            for(int j=0;j<tmp.size();j++){
                String str=")";
                if((str+tmp.get(j)).equals("(())()")){
                    System.out.println(left);
                    System.out.println(right);
                }
                System.out.println((str+tmp.get(j)));
                ans.add(str+tmp.get(j));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        test s=new test();
        System.out.println(s.generateParenthesis(4));
    }

}
