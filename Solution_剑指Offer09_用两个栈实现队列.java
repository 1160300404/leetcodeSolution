import java.util.Stack;

public class Solution_剑指Offer09_用两个栈实现队列 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Solution_剑指Offer09_用两个栈实现队列() {
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()&&stack2.isEmpty()) return -1;
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
