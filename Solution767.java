package Solution;
// 重构字符串
public class Solution767 {
    public String reorganizeString(String S) {
        if(S.length()<2)
            return S;
        System.out.println();
        int length=S.length();
        int[] cnt=new int[26];
        int maxcnt=0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            cnt[c - 'a']++;
            maxcnt = Math.max(maxcnt, cnt[c - 'a']);
        }
        if(maxcnt>(length+1)/2){
            return "";
        }
        char[] ans = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for(int i=0;i<26;i++){
            char c=(char)('a'+i);
            while(cnt[i]>0&&cnt[i] <= halfLength&&oddIndex<length){
                ans[oddIndex]=c;
                cnt[i]--;
                oddIndex+=2;
            }
            while(cnt[i]>0){
                ans[evenIndex]=c;
                cnt[i]--;
                evenIndex+=2;
            }
        }
        return new String(ans);
    }
}
