package com.leetcode.bit;

/**
 * @ClassName HammingWeight
 * @Description 剑指offer19
 * @Author wangmeng
 * @Date 2021/3/28
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(11));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res ++;
            n = n & (n - 1);
        }
        return res;
    }
}
