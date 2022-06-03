package algorithm.leetcode.math;

import java.util.HashSet;

/**
 * @ClassName HappyNumber
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/5
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }

    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            // if it has the circle
            int squareSum = calculateSquareSum(n);
            if (set.contains(squareSum)) return false;
            set.add(squareSum);
            n = squareSum;
        }
        return true;
    }

    public int calculateSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int reminder = n % 10;
            sum += reminder * reminder;
            n /= 10;
        }
        return sum;
    }
}
