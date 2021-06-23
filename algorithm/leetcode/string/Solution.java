package com.leetcode.string;

import java.util.HashMap;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/2/27
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("abababacab", 4));
    }

    public int longestSubstring(String s, int k) {
        char[] sdf= s.toCharArray();
        int len = sdf.length;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String temp = s.substring(i, j + 1);
                if (isValid(temp, k) && temp.length() > maxLen) maxLen = temp.length();
            }
        }
        return maxLen;
    }

    // judge if it is valid
    public Boolean isValid(String str, int k) {
        HashMap<Character, Integer> hashMap = new HashMap();
        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            Integer count = hashMap.get(temp[i]);
            if (count == null) {
                hashMap.put(temp[i], 1);
            } else {
                hashMap.put(temp[i], ++count);
            }
        }
        // traverse hashmap
        for (Integer sum : hashMap.values()) {
            if (sum < k ) return false;
        }
        return true;
    }
}
