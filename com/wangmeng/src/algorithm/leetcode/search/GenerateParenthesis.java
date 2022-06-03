package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/12/30
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis(2);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
//        dfsSolution1(ans, sb, n, 0, 0);
        dfsSolution2(ans, sb, n, n, n);
        return ans;
    }

    public void dfsSolution1(ArrayList<String> ans, StringBuilder sb, int n, int openCount, int closeCount) {
        if (openCount == n && closeCount == n) {
            ans.add(sb.toString());
            return;
        }

        Character[] parenthesis = new Character[]{'(', ')'};
        for (int i = 0; i < 2; i++) {
            // prune
            if (i == 1 && closeCount >= openCount) return;
            if (i == 0 && openCount >= n) continue;
            sb.append(parenthesis[i]);
            if (i == 0) {
                dfsSolution1(ans, sb, n, openCount + 1, closeCount);
            } else {
                dfsSolution1(ans, sb, n, openCount, closeCount + 1);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public void dfsSolution2(ArrayList<String> ans, StringBuilder sb, int n, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            ans.add(sb.toString());
            return;
        }

        if (openCount > 0) {
            sb.append('(');
            dfsSolution2(ans, sb, n, openCount - 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount > 0) {
            sb.append(')');
            dfsSolution2(ans, sb, n, openCount, closeCount - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
