import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。

字谜的迷面puzzle 按字符串形式给出，如果一个单词word符合下面两个条件，那么它就可以算作谜底：

单词word中包含谜面puzzle的第一个字母。
单词word中的每一个字母都可以在谜面puzzle中找到。
例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"
而 "beefed"（不含字母 "a"）以及"based"（其中的 "s" 没有出现在谜面中）。
返回一个答案数组answer，数组中的每个元素answer[i]是在给出的单词列表 words
中可以作为字谜迷面puzzles[i]所对应的谜底的单词数目。


 */
public class Solution_1178_猜字谜 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        //方法一
        for (String puzzle : puzzles) {
            int total=0;
            for (int i = 0; i < (1 << 6); i++) {
                int mask = 0;
                for (int j = 0; j < 6; j++) {
                    if ((i & (1 << j)) !=0) {
                        mask |= (1 << (puzzle.charAt(j+1)-'a'));
                    }
                }
                mask |= (1 << (puzzle.charAt(0) - 'a'));
                if(frequency.containsKey(mask)){
                    total+=frequency.get(mask);
                }
            }
            ans.add(total);
        }
//        for (String puzzle : puzzles) {
//            int total = 0;
//            int mask = 0;
//            for (int i = 1; i < 7; i++) {
//                mask |= (1 << (puzzle.charAt(i) - 'a'));
//            }
//            int subset = mask;
//            do {
//                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
//                if (frequency.containsKey(s)) {
//                    total += frequency.get(s);
//                }
//                subset = (subset - 1) & mask;
//            } while (subset != mask);
//            ans.add(total);
//        }
        return ans;
    }
}
