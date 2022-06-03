package algorithm.leetcode.search;

import java.util.*;

/**
 * @ClassName WordLadder
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/10
 */
public class WordLadder {

    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("hot");
        strs.add("dot");
        strs.add("dog");
        strs.add("lot");
        strs.add("log");
        strs.add("cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", strs));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;
        wordset.remove(beginWord);
        LinkedList<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.addLast(beginWord);
        int ans = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String str = queue.removeFirst();
                List<String> adjacents = getAdjacents(str, wordset, used);
                for (String s : adjacents) {
                    if (s.equals(endWord)) return ans + 1;
                    queue.addLast(s);
                    used.add(s);
                }
            }
            ans++;
        }
        return 0;
    }

    public List<String> getAdjacents(String str, Set<String> wordset, Set<String> used) {
        List<String> adjacents = new ArrayList<>();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char curr = charArray[i];
            for (char x = 'a'; x <= 'z'; x++) {
                if (x == curr) continue;
                charArray[i] = x;
                String genStr = String.valueOf(charArray);
                // judge if it is valid
                if (used.contains(genStr)) continue;
                if (wordset.contains(genStr)) adjacents.add(genStr);
            }
            charArray[i] = curr;
        }
        return adjacents;
    }
}
