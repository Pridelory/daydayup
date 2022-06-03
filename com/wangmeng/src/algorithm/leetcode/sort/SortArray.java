package algorithm.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName SortArray
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/2/13
 */
public class SortArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 3, 7, 8, 6, 59, 1, 34, 50, 64, 56, 87, 123, 54, 28, 95};
        new SortArray().bubbleSort(nums);
        for (int i : nums) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    /**
     * 冒泡排序
     *
     * time complexity -> o(n^2)
     * space complexity -> o(1)
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


}
