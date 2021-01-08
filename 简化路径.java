package Solution;

import java.util.Stack;

public class 简化路径 {
    public String simplifyPath (String path) {
        // write code here
        String[] path_list=path.split("/");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<path_list.length;i++){
            if(path_list[i].equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else if(!path_list[i].equals(".")&&!path_list[i].equals("")){
                stack.push(path_list[i]);
            }
        }
        if(stack.isEmpty())
            return "/";
        String res="";
        while(!stack.isEmpty()){
            String tmp=stack.pop();
            res="/"+tmp+res;
        }
        return  res;
    }

    public static void main(String[] args) {
        简化路径 s=new 简化路径();
        System.out.println(s.simplifyPath("/../"));
    }
}
