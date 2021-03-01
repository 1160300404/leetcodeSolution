package zhousai229;

public class 交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        int length_1=word1.length(),length_2=word2.length(),index=0;
        char[] c1=word1.toCharArray(),c2=word2.toCharArray();
        StringBuilder sb=new StringBuilder();
        while(length_1>index&&length_2>index){
            sb.append(c1[index]);
            sb.append(c2[index]);
            index++;
        }
        sb.append(index==length_1?word2.substring(index,length_2):word1.substring(index,length_1));
        return sb.toString();
    }
}
