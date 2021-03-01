/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution_剑指Offer33二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return ispostorder(postorder,0,postorder.length-1);
    }
    public boolean ispostorder(int[] postorder,int begin,int end){
        if(begin>=end) return true;
        int index=end-1;
        while(index>=begin){
            if(postorder[index]>postorder[end]){
                index--;
            }else {
                break;
            }
        }
        return ispostorder(postorder,begin,index)&&ispostorder(postorder,index+1,end-1);
    }
}
