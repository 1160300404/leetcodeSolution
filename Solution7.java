package Solution;

public class Solution7 {
    public int reverse(int x) {
        int y=Math.abs(x);
        long ans=0;
        while(y!=0){
            ans=ans*10+y%10;
            y=y/10;
        }
        if(x<0){
            ans=-ans;
        }
        return (int)ans==ans? (int)ans:0;
    }
}
