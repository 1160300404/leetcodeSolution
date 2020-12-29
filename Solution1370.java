package Solution;


public class Solution1370 {
    public String sortString(String s) {
        int[] nums=new int[26];
        for(int i=0;i<s.length();i++){
            nums[s.charAt(i)-'a']++;
        }
        StringBuffer ret = new StringBuffer();
        while(ret.length()!=s.length()){
            for(int i=0;i<26;i++){
                if(nums[i]>0){
                    ret.append((char) (i + 'a'));
                    nums[i]--;
                }
            }
            for(int i=25;i>=0;i--){
                if(nums[i]>0){
                    ret.append((char) (i + 'a'));
                    nums[i]--;
                }
            }
        }
        return ret.toString();
    }
}
