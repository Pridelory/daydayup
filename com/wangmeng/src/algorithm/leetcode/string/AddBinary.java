package algorithm.leetcode.string;

/**
 * @ClassName AddBinary
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/4
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        if (lenA < lenB) {
            for (int i = 0; i < Math.abs(lenA - lenB); i++) {
                a = "0".concat(a);
            }
        }
        if (lenB < lenA) {
            for (int i = 0; i < Math.abs(lenA - lenB); i++) {
                b = "0".concat(b);
            }
        }
        boolean flag = false;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int subA = a.charAt(i) - '0';
            int subB = b.charAt(j) - '0';
            int sum = flag ? subA + subB + 1 : subA + subB;
            int currNum = sum % 2;
            sb.append(currNum + "");
            flag = sum > 1 ? true : false;
        }
        if (flag) sb.append("1");
        return sb.reverse().toString();
    }
}
