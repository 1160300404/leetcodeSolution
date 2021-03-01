/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排
序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
该数组的最小值为1。


 */
public class Solution_剑指Offer_11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        return  minnum(numbers,0,numbers.length-1);
    }
    public int minnum(int[] numbers,int start,int end){
        while(end-start>1){
            int mid=start+(end-start)/2;
            if(numbers[mid]>numbers[end]) start=mid++;
            if(numbers[mid]<numbers[start]) end=mid--;
        }
        return Math.min(numbers[end],numbers[start]);
    }
}
