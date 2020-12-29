package Solution;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        if(numRows<1){
            return null;
        }
        StringBuilder result=new StringBuilder();
        int length=s.length();
        int k=(2*numRows-2);
        for(int i=0;i<numRows;i++){
            int tmp=i;
            while(tmp<length){
                if(i==0||i==(numRows-1)){
                    result.append(s.charAt(tmp));
                    tmp+=k;
                }else{
                    result.append(s.charAt(tmp));
                    if((tmp+k-2*i)<length)
                        result.append(s.charAt(tmp+k-2*i));
                    tmp+=k;
                }
            }
        }
        return  result.toString();
    }
}
