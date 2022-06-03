package algorithm.leetcode.dp.knapsack;

/**
 * @ClassName knapsack_01
 * @Description example simulation
 * @Author wangmeng
 * @Date 2021/10/14
 */
public class knapsack_01 {
    public static void main(String[] args) {
        int[] weight = {1, 2, 3, 4};
        int[] value = {100, 130, 160, 240};
        int limit = 4;
        System.out.println(new knapsack_01().optimization01Dp(weight, value, limit));
    }

    // original 01 dp
    public int original01Dp(int[] weight, int[] value, int limit) {
        int[][] dp = new int[weight.length + 1][limit + 1];

        for (int i = 1; i <= weight.length; i++) {
            System.out.println();
            for (int j = 1; j <= limit; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
                System.out.print(dp[i][j] + " ");
            }
        }
        System.out.println();
        return dp[weight.length][limit];
    }

    // optimization 01 dp
    public int optimization01Dp(int[] weight, int[] value, int limit) {
        int[] dp = new int[limit + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = limit; j >= 0; j--) {
                if (j >= weight[i - 1])
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[limit];
    }
}
