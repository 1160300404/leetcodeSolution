package Solution;

public class 二级制求和 {
    public String addBinary (String a, String b) {
        // write code here
        int a_int=a.length(),b_int=b.length();
        int add=0;
        String ans="";
        while (a_int>0&&b_int>0){
            int tmp_a=Integer.parseInt(a.substring(a_int-1,a_int));
            int tmp_b=Integer.parseInt(b.substring(b_int-1,b_int));
            int tmp=(add+tmp_a+tmp_b)%2;
            add=(add+tmp_a+tmp_b)/2;
            ans=tmp+ans;
            a_int--;
            b_int--;
        }
        String left_str=a_int>0?a:b;
        int left=a_int>0?a_int:b_int;
        while (left>0){
            int tmp_left=Integer.parseInt(left_str.substring(left-1,left));
            int tmp=(add+tmp_left)%2;
            add=(add+tmp_left)/2;
            ans=tmp+ans;
            left--;
        }
        if(add==1)
            ans=add+ans;
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        二级制求和 s=new 二级制求和();
        s.addBinary("","");

    }
}
