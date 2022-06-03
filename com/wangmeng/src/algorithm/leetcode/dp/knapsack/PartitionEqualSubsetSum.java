package algorithm.leetcode.dp.knapsack;

import algorithm.leetcode.search.Permutations;

import java.util.Arrays;

/**
 * @ClassName PartitionEqualSubsetSum
 * @Description partition Equal subset sum
 * @Author wangmeng
 * @Date 2021/10/14
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[len + 1][target + 1];

//        if (nums[0] <= target) {
//            dp[0][nums[0]] = true;
//        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] == j) {
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];
    }
}
