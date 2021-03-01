import java.util.Stack;

public class Solution剑指Offer31_栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int count_pop=0;
        int count_push=0;
        while(count_pop<popped.length){
            while(stack.isEmpty()||stack.peek()!=popped[count_pop]){
                if(count_push==pushed.length) break;
                stack.push(pushed[count_push]);
                count_push++;
            }
            if(stack.peek()!=popped[count_pop]) break;
            stack.pop();
            count_pop++;
        }
        if(count_pop==popped.length) return true;
        return  false;

    }
}
