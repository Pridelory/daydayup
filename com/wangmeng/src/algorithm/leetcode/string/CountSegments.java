package algorithm.leetcode.string;

/**
 * @ClassName CountSegments
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/8
 */
public class CountSegments {

    public static void main(String[] args) {
        System.out.println(new CountSegments().countSegments("       "));

    }

    public int countSegments(String s) {
        String[] str = s.split("\\s+");
        if (str.length == 0) return 0;
        if (str[0].equals("")) return str.length - 1;
        return str.length;
    }
}
