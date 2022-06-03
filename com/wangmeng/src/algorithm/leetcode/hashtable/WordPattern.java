package algorithm.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WordPattern
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/8
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (pattern.length() != str.length) return false;
        Map<Character, String> hashmap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (hashmap.containsKey(pattern.charAt(i))) {
                if (hashmap.get(pattern.charAt(i)).equals(str[i])) {
                    return true;
                } else {
                    return false;
                }
            } else {
                hashmap.put(pattern.charAt(i), str[i]);
            }
        }
        return true;
    }
}
