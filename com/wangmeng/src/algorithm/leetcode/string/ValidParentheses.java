package algorithm.leetcode.string;

import java.util.Stack;

/**
 * @ClassName ValidParentheses
 * @Description
 * @Author wangmeng
 * @Date 2021/12/27
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character chr = s.charAt(i);
            if (chr == '(' || chr == '[' || chr == '{') {
                stack.push(chr);
            }
            if (chr == ')' || chr == ']' || chr == '}') {
                if (stack.isEmpty()) return false;
                Character chr_1 = (Character)stack.pop();
                if (chr == ')' && chr_1 != '(') return false;
                if (chr == ']' && chr_1 != '[') return false;
                if (chr == '}' && chr_1 != '{') return false;
            }
        }
        return stack.isEmpty() ? true: false;
    }
}
