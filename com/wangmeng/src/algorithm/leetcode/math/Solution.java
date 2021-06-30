package algorithm.leetcode.math;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/3/25
 */
class Solution {
    public long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long start_0 = 0;
        long start_1 = 1;
        long result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = (start_0 + start_1) % 1000000007;
            start_0 = start_1;
            start_1 = result;
        }
        return result;
    }

    public int fibRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(48));
    }
}
