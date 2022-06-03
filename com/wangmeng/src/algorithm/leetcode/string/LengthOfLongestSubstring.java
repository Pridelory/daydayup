package algorithm.leetcode.string;

import java.util.HashSet;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/1/5
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            ans = Math.max(ans, set.size());
            set.clear();
        }
        return ans;
    }
}
