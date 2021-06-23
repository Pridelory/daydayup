package com.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName LargetNumber
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/4/12
 */
public class LargetNumber {
    public static void main(String[] args) {
        String[] strArray = new String[]{"3", "34", "30", "5", "9"};
        Arrays.sort(strArray);
        for (String temp : strArray) {
            System.out.println(temp);
        }
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));

        StringBuilder sb = new StringBuilder();
        for (String tempStr : strArr) {
            sb.append(tempStr);
        }
        String result = sb.toString();
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }
}
