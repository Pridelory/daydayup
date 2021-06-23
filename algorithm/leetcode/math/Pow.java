package com.leetcode.math;

/**
 * @ClassName Pow
 * @Description 快速幂
 * @Author wangmeng
 * @Date 2021/3/29
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2, -2));
    }

    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
    }

    public double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
