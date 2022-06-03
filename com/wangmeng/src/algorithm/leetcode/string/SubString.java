package algorithm.leetcode.string;

/**
 * @ClassName SubString
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/21
 */
public class SubString {
    public static void main(String[] args) {
        System.out.println(new SubString().strStr("ll", "lloob"));
    }

    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            boolean flag = true;
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}
