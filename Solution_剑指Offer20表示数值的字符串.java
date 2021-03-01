public class Solution_剑指Offer20表示数值的字符串 {
    public boolean isNumber(String s) {
        boolean ans=false;
        int index=getnum(s,0);

        if(index>0) ans=true;
        if(s.charAt(index)=='.'){
            int oldindex=index;
            index=getnum(s,oldindex+1);
            ans=ans||(index>oldindex);
        }
        if(s.charAt(index)=='e'||s.charAt(index)=='E'){
            int oldindex=index;
            index=getnum(s,oldindex+1);
            ans=ans&&(index>oldindex);
        }
        return ans&&index==s.length();
    }
    public int getnum(String s,int index){
//        int index=0;
        if(s.charAt(index)=='+'||s.charAt(index)=='-'){
            index++;
        }
        return getunsignednum(s,index);
    }
    public int getunsignednum(String s,int index){
        if(index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            index++;
        }
        return index;
    }
}
