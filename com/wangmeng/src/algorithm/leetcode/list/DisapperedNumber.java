package algorithm.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DisapperedNumber
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/1/1
 */
public class DisapperedNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        new DisapperedNumber().findDisappearedNumbers(arr);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList();
        if (nums == null || nums.length == 0) return ans;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
