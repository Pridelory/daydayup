package algorithm.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindDuplicates
 * @Description TODO
 * @Author wangmeng
 * @Date 2022/1/2
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(new FindDuplicates().findDuplicates(arr));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        for (int i = 0; i < nums.length; i++) {
            int absV = Math.abs(nums[i]) - 1;
            if (nums[absV] < 0) {
                ans.add(absV + 1);
            } else {
                nums[absV] = - nums[absV];
            }
        }

        return ans;
    }
}
