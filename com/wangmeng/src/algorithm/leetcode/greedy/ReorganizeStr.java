package algorithm.leetcode.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName ReorganizeStr
 * @Description leetcode 767
 * @Author wangmeng
 * @Date 2022/2/20
 */
public class ReorganizeStr {
    public static void main(String[] args) {
        System.out.println(new ReorganizeStr().reorganizeString("abbbaaabab"));
    }

    public String reorganizeString(String s) {
        char[] str = s.toCharArray();
        // count for every character
        int[] table = new int[26];
        int maxCount = 0;
        for (int i = 0; i < str.length; i++) {
            if (table[str[i] - 'a'] + 1 > maxCount) maxCount = table[str[i] - 'a'] + 1;
            table[str[i] - 'a']++;
        }

        if (maxCount > (str.length + 1) / 2) return "";

        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                int o1Index = table[letter1 - 'a'];
                int o2Index = table[letter2 - 'a'];
                if (o1Index == o2Index) return letter1.compareTo(letter2);
                return o2Index - o1Index;
            }
        });

        for (int i = 0; i < str.length; i++) {
            queue.add(str[i]);
        }

        char[] ans = new char[str.length];
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
        for (int i = 0; i < ans.length; i += 2) {
            ans[i] = queue.poll();
        }

        for (int i = 1; i < ans.length; i+= 2) {
            ans[i] = queue.poll();
        }

        return String.valueOf(ans);
    }
}
