package algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IsIsomorphic
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/5
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("badc", "bada"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
