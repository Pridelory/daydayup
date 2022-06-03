package algorithm.leetcode.binary_search;

/**
 * @ClassName BinaryRecursion
 * @Description TODO
 * @Author wangmeng
 * @Date 2021/10/22
 */
public class BinaryRecursion {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        new BinaryRecursion().sort(nums, 0, nums.length - 1);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public double avg(int[] nums, int left, int right) {
        if (left == right) return 1.0 * nums[left] / nums.length;
        int mid = left + (right - left) / 2;
        // left interval
        double leftAvg = avg(nums, left, mid);
        // right interval
        double rightAvg = avg(nums, mid + 1, right);
        return leftAvg + rightAvg;
    }

    public void sort(int[] nums, int left, int right) {
        if (left == right) return;
        if (left + 1 == right) {
            if (nums[left] > nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
    }
}


