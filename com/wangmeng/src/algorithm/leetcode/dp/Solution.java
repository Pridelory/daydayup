package algorithm.leetcode.dp;

/**
 * @ClassName Solution
 * @Description 切绳子
 * @Author wangmeng
 * @Date 2021/3/27
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];

        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
