package algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName TheClosestPair
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/10/23
 */
public class TheClosestPair {
    public static void main(String[] args) {
        int[] nums = new int[]{-23, -32, -19, -1, 3, 6, 9, 100};
        System.out.println(new TheClosestPair().method_2(nums));
    }

    public int method_1(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp < ans) ans = temp;
        }
        return ans;
    }

    public int method_2(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = Math.abs(nums[j] - nums[i]);
                if (temp < ans) ans = temp;
            }
        }
        return ans;
    }
}
