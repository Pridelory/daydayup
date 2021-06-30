package algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * @ClassName Climb
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/5/7
 */
public class Climb {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Climb().climbStairs(5));
    }
}
