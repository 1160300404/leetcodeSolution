/*
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Solution43_字符串相乘 {
    public String multiply (String num1, String num2) {
        // write code here
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int length_1=num1.length();
        int length_2=num2.length();
        String ans="0";
        for(int i=length_2-1;i>=0;i--){
            int index_1=length_2-i-1;
            int num=Integer.valueOf(num2.charAt(i)+"");
            int add=0;
            StringBuilder tmp_ans=new StringBuilder();
            for(int j=length_2-1;j>i;j--) tmp_ans.append('0');
            for(int j=length_1-1;j>=0;j--){
                int num_2=Integer.valueOf(num1.charAt(j)+"")*num+add;
                add=num_2/10;
                num_2=num_2%10;
                tmp_ans.insert(0,Character.forDigit(num_2,10));
            }
            if(add>0) tmp_ans.insert(0,Character.forDigit(add,10));
            String tmp=tmp_ans.toString();
            tmp_ans=new StringBuilder();
            add=0;
            for(int j=ans.length()-1;j>=0;j--){
                int index=tmp.length()-ans.length()+j;
                int num_2=Integer.valueOf(ans.charAt(j)+"")+Integer.valueOf(tmp.charAt(index)+"")+add;
                add=num_2/10;
                num_2=num_2%10;
                tmp_ans.insert(0,Character.forDigit(num_2,10));
            }
            for(int j=tmp.length()-ans.length()-1;j>=0;j--){
                int num_2=Integer.valueOf(tmp.charAt(j)+"")+add;
                add=num_2/10;
                num_2=num_2%10;
                tmp_ans.insert(0,Character.forDigit(num_2,10));
            }
            ans=tmp_ans.toString();
            // System.out.println(ans);
        }
        return  ans;
    }
}
