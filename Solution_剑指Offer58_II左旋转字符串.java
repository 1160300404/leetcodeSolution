/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
该函数将返回左旋转两位得到的结果"cdefgab"。

 */
public class Solution_剑指Offer58_II左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        if(n==s.length()) return s;
        char[] array=s.toCharArray();
        int length=array.length;
        int left=0,right=length-1;
        reverse(array,left,right);
        left=length-n;right=length-1;
        reverse(array,left,right);
        left=0;right=length-n-1;
        reverse(array,left,right);
        return new String(array);
    }
    public void reverse(char[] array ,int left,int right){
        while(left<right){
            char tmp=array[left];
            array[left]=array[right];
            array[right]=tmp;
            left++;right--;
        }
        return;
    }
}
