import java.util.Arrays;

public class  Solution_剑指Offer50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        int[] array=new int[26];
        int length=s.length();
        Arrays.fill(array,-1);
        for(int i=0;i<length;i++){
            int index=s.charAt(i)-'a';
            if(array[index]==-1) array[index]=i;
            else if(array[index]>=0) array[index]=-2;
        }
        for(int i=0;i<26;i++){
            if(array[i]>=0&&array[i]<length){
                length=array[i];
            }
        }
        if(length>=s.length()) return ' ';
        return s.charAt(length);
    }
}
