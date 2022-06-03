package algorithm.leetcode.recursion;

import java.util.Arrays;

/**
 * @ClassName CanPartitionKSubsets
 * @Description if it can be partitioned to k subsets
 * @Author wangmeng
 * @Date 2021/10/5
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) {
        int[] sums = {2,2,2,2,3,4,5,4};
        System.out.println(new CanPartitionKSubsets().canPartitionKSubsets(sums, 4));
    }

    public boolean canPartitionKSubsets(int[] sums, int k) {
        int sum = Arrays.stream(sums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(sums);
        int target = sum / k;
        boolean[] used = new boolean[sums.length];
        return dfs(sums, used, target, k, 0, 0);
    }

    public boolean dfs(int[] sums, boolean[] used, int target, int k, int curSum, int begin) {
        if (k == 1) return true;
        if (curSum == target) {
            return dfs(sums, used, target, k - 1, 0, 0);
        }

        for (int i = begin; i < sums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (curSum + sums[i] > target) {
                continue;
            }

            // forward
            used[i] = true;
            if (dfs(sums, used, target, k - 1, curSum + sums[i], i + 1)) {
                return true;
            }

            // backward
            used[i] = false;
        }
        return false;
    }
}
