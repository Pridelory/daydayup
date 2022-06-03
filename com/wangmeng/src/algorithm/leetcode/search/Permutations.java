package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Permutations
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/9/18
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new Permutations().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, nums, used, path, len);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> path, int len) {
        if (path.size() == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(ans, nums, used, path, len);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
