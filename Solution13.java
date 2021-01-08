package leetcode;

//罗马数字转整数

/***
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution13 {
    public int romanToInt(String s) {
        char[] arry=s.toCharArray();
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(arry[i]=='I'){
                if(i==s.length()-1||(arry[i+1]!='V'&&arry[i+1]!='X')){
                    ans+=1;
                }else if(arry[i+1]=='V'){
                    i++;
                    ans+=4;
                }else if(arry[i+1]=='X'){
                    i++;
                    ans+=9;
                }
            }else if(arry[i]=='V'){
                ans+=5;
            }else if(arry[i]=='X'){
                if(i==s.length()-1||(arry[i+1]!='L'&&arry[i+1]!='C')){
                    ans+=10;
                }else if(arry[i+1]=='L'){
                    i++;
                    ans+=40;
                }else if(arry[i+1]=='C'){
                    i++;
                    ans+=90;
                }
            }else if(arry[i]=='L'){
                ans+=50;
            }else if(arry[i]=='C'){
                if(i==s.length()-1||(arry[i+1]!='D'&&arry[i+1]!='M')){
                    ans+=100;
                }else if(arry[i+1]=='D'){
                    i++;
                    ans+=400;
                }else if(arry[i+1]=='M'){
                    i++;
                    ans+=900;
                }
            }else if(arry[i]=='D'){
                ans+=500;
            }else if(arry[i]=='M'){
                ans+=1000;
            }
        }
        return ans;
    }
}
