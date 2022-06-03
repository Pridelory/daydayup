package algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName FindRepeatedDnaSequences
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/3/7
 */
public class FindRepeatedDnaSequences {
    public static void main(String[] args) {
        List<String> list = new FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAAAAAAAA");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (hashSet.contains(str)) {
                ans.add(str);
            } else {
                hashSet.add(str);
            }
        }
        return ans;
    }
}
