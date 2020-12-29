package Solution;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        int ans=0;
        Set<String> opts=new HashSet<>();
        opts.add("+");
        opts.add("-");
        opts.add("*");
        opts.add("/");
        //String[] opts={"+","-","*","/"};
        for(int i=0;i<tokens.length;i++){
            if(opts.contains(tokens[i])) {
                int tmp1 = Integer.parseInt(stack.pop());
                int tmp2 = Integer.parseInt(stack.pop());
                tokens[i]=getans(tmp1,tmp2,tokens[i]);
            }
            stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());
    }
    private String getans(int tmp1,int tmp2,String opt){
        int ans=0;
        if(opt.equals("+"))
            ans=tmp1+tmp2;
        else if (opt.equals("*"))
            ans=tmp1*tmp2;
        else if(opt.equals("-"))
            ans=tmp1-tmp2;
        else
            ans=tmp1/tmp2;
        return  String.valueOf(ans);
    }
}
