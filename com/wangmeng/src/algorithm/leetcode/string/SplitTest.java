package algorithm.leetcode.string;

/**
 * @ClassName SplitTest
 * @Description
 * public String[] split(String regex, int limit)
 * regex代表正则表达式 注意：. $ | * 等转义字符 前面需要加上\\
 * limit代表正则表达式运用的次数 0代表无限次
 * @Author wangmeng
 * @Date 2022/2/9
 */
public class SplitTest {
    public static void main(String[] args) {
//        String str = " dog cat   lion";
        String str = "www.google.com";
        String[] split = str.split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
